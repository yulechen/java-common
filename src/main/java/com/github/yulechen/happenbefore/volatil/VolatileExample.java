package com.github.yulechen.happenbefore.volatil;

import java.util.Date;
import java.util.concurrent.locks.LockSupport;

public class VolatileExample {

    private volatile int a = 0;
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
        private VolatileExample ve;

        public ReadTask(VolatileExample ve) {
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
        private VolatileExample ve;
        private int  i;

        public void setI(int i) {
            this.i = i;
        }

        public WriteTask(VolatileExample ve) {
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
         * write maybe before read
         */
        for(int j =0; j<10 ;j++) {
            System.out.println("VolatileExample  Test Result:");
            System.out.println("Write                       Read");
            VolatileExample ve = new VolatileExample();
            ReadTask readTask = new ReadTask(ve);
            WriteTask writeTask = new WriteTask(ve);

            for (int i = 0; i < 10; i++) {
                new Thread(readTask,""+i).start();
                new Thread(writeTask,""+i).start();
            }
            LockSupport.parkUntil(new Date().getTime()+10*1000);
            System.out.println("===========================================");
        }



    }
}
