package com.github.yulechen.concurrency;

public class VolatileCompilerTest {

  private volatile int a = 0;
  private int b = 0;
  private int c = 0;

  public void write() {
    b = 2;
    c = 3;
    // flust a to main memorey and nofity other cpu a, b,and c is modifyed (not only a )
    // ,so b,c is invid ,other cpu must reload b,c
    a = 1;

  }


  public int read() {
    if(a==1){
      // happen-before this guar bu JVM.
      //MUST be b=2 and c=3
    }
    return b+c;
  }

  public static void main(String[] args) {
    VolatileCompilerTest test =new VolatileCompilerTest();
    System.out.println(test.read());
  }
}
