package com.github.yulechen.concurrency;

class FinalFieldExample {

  final int x;
  int y;
  static FinalFieldExample f;

  public FinalFieldExample() {
    x = 3;
    y = 4;
  }

  static void writer() {
    f = new FinalFieldExample();
  }

  static void reader() {
    // final field happen-before
    if (f != null) {
      int i = f.x; // guaranteed to see 3
      int j = f.y; // could see 0
    }
  }
}
