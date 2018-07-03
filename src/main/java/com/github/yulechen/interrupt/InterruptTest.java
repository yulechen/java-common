package com.github.yulechen.interrupt;

/**
 * 停止线程测试
 */
public class InterruptTest {


    public static void main(String[] args) throws InterruptedException {

           MyTask task =new MyTask();
           task.name="1";
           task.start();
           Thread.sleep(1000);
           MyTask task2 =new MyTask();
           task2.name="2";
           task2.start();
           while (true)
              task.yield();
         //  System.out.println("-----------");

    }



}
