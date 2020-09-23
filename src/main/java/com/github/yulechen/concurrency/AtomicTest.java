package com.github.yulechen.concurrency;

import java.util.ArrayList;
import java.util.List;

public class AtomicTest {

  // 保证 缓存一致性协议及时生效
 private volatile int a =0;

 private void safeCount(){
   // 第一次读 a
   // 第二次读a
   while(true){
     int la =a;// 本地 cpu执行
     la=la+1;
     // 写 a
     a=la; // if true {break},写成功，有可能写失败 cas 执行成功 释放lock
     break;
   }
 }

  public static void main(String[] args) throws InterruptedException {
    long start =System.currentTimeMillis();
    List<Thread> threadList =new ArrayList<>();
    AtomicTest test  =new AtomicTest();
    for(int j =0 ;j<100;j++){
      threadList.add(new Thread(()->{
        for(int i=0;i<1000;i++)
        test.safeCount();
      }));
    }
    for (Thread thread : threadList) {
      thread.start();
    }
    for (Thread thread : threadList) {
      thread.join();
    }
    System.out.println(test.a);
    System.out.print((System.currentTimeMillis())-start);

  }


}
