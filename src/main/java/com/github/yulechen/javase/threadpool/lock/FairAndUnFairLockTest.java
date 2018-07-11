package com.github.yulechen.javase.threadpool.lock;

public class FairAndUnFairLockTest {

    // 公平锁，先来先执行
    FIFOMutex mutex = new FIFOMutex();

    public static void main(String[] args) {
        FairAndUnFairLockTest test = new FairAndUnFairLockTest();
//         for(int i=0 ;i< 20 ;i++){
//            Thread task = new MyTask(""+i,test,true);
//            task.start();
//        }

        for(int i=0 ;i< 20 ;i++){
            Thread task = new MyTask("a"+i,test,false);
            task.start();
        }
    }


    /**
     * 公平锁
     * @throws InterruptedException
     */
    public void sysOut() throws InterruptedException {
        mutex.lock();
        Thread.sleep(100);
        System.out.println(Thread.currentThread().getName());
        mutex.unlock();
    }
    /**
     * 不公平锁
     * @throws InterruptedException
     */
    public synchronized   void sysOutSyn() throws InterruptedException {

        Thread.sleep(100);
        System.out.println(Thread.currentThread().getName());

    }


    static  class MyTask extends Thread{

        private FairAndUnFairLockTest test ;

        private boolean fair;

        public MyTask(String name, FairAndUnFairLockTest test, boolean fair) {
            super(name);
            this.test = test;
            this.fair=fair;
        }

        @Override
        public void run() {
            try {
                if(fair)
                 test.sysOut();
                else
                    test.sysOutSyn();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
