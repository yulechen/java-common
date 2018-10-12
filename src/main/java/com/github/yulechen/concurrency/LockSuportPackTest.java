package com.github.yulechen.concurrency;

import java.util.concurrent.locks.LockSupport;

public class LockSuportPackTest {

    public static void main(String[] args) throws InterruptedException {


        Thread task = new Task1();
        task.start();
        Thread.sleep(5000);

        System.out.println("解锁 线程阻塞。");
        LockSupport.unpark(task);
        LockSupport.park();
    }


    static class Task1 extends  Thread{

        @Override
        public void run() {
            while(true){
                for(int i =0 ;i<1000 ;i++){
                    System.out.println(i);
                    if(i==999 ){
                        System.out.println("线程阻塞。");
                        LockSupport.park();
                    }
                }
            }

        }
    }


}
