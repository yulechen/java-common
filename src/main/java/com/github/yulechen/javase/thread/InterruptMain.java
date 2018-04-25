package com.github.yulechen.javase.thread;

import java.util.concurrent.locks.LockSupport;

public class InterruptMain {


    static class MyTask extends Thread {
        @Override
        public void run() {
            try {
                int i = 0;
                while (i < Integer.MAX_VALUE) {
                    i++;
                    if (i % 100000000 == 0) {
                        System.out.println(i);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new MyTask();
        t1.start();
        Thread.sleep(2000);
        t1.interrupt();
        System.out.println("ined======================================");
        LockSupport.park();
    }
}
