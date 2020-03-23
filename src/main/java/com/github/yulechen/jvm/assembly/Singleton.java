package com.github.yulechen.jvm.assembly;

public class Singleton {

  private Singleton() {
  }

  public static Object getInstance(boolean flag) {
    if (flag) {
      return new LazyHolder[2];
    }
    return LazyHolder.INSTANCE;
  }

  public static void main(String[] args) {
    getInstance(true);
    System.out.println("----");
    getInstance(false);
  }

  private static class LazyHolder {

    static final Singleton INSTANCE = new Singleton();

    static {
      System.out.println("LazyHolder.");
    }
  }
}