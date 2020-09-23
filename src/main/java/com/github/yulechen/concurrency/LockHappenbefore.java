package com.github.yulechen.concurrency;

public class LockHappenbefore {


  private int X;
  private int Y;

  private Object lock = new Object();


  public void t1() {
    X = 1;
    synchronized (lock) {
      Y = 1;
    }
  }


  public void t2() {
    synchronized (lock) {
      int r1 = Y;
    }
    int r2 = X;
  }

  /**
   * if t2 run first;
   *      r2=1. or 0
   * if t1 run first;
   *     r2 must be 1
   */

}
