package com.github.yulechen.happenbefore.volatil;

import java.util.Date;
import java.util.concurrent.locks.LockSupport;

public class NormalExample {

    private  int a = 0; // none volatile
    private  int  k=0;

    public void setA(int i) throws InterruptedException {
        Thread.sleep(1000);
        k=2;
        a = 1;
        System.out.println("["+Thread.currentThread().getName()+"] a="+a);

    }

    public int getA() throws InterruptedException {
        Thread.sleep(1000) ;
        System.out.println("                            ["+Thread.currentThread().getName()+"] "+a+":"+k);
        return a;

    }

    static class ReadTask implements Runnable {
        private NormalExample ve;

        public ReadTask(NormalExample ve) {
            this.ve = ve;
        }

        @Override
        public void run() {
            try {
              ve.getA();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class WriteTask implements Runnable {
        private NormalExample ve;
        private int  i;

        public void setI(int i) {
            this.i = i;
        }

        public WriteTask(NormalExample ve) {
            this.ve = ve;
        }

        @Override
        public void run() {
            try {
                ve.setA(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
        /**
         * write must before read
         */
        for(int j =0; j<10 ;j++) {
            System.out.println("NormalExample  Test Result:");
            System.out.println("Write                       Read");
            NormalExample ve = new NormalExample();
            NormalExample.ReadTask readTask = new NormalExample.ReadTask(ve);
            NormalExample.WriteTask writeTask = new NormalExample.WriteTask(ve);

            for (int i = 0; i < 10; i++) {
                new Thread(readTask,""+i).start();
                new Thread(writeTask,""+i).start();
            }
            LockSupport.parkUntil(new Date().getTime()+10*1000);
            System.out.println("===========================================");
        }


    }
}
