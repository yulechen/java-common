package com.github.yulechen.newcode.hw.simple;

public class PutApples {


  static int putApples(int m, int n) {
    if (m < 0) {
      return 0;
    }
    if (m == 1 || n == 1) {
      return 1;
    }
    return putApples(m, n - 1) + putApples(m - n, n);
  }


  public static void main(String[] args) {
    System.out.println(putApples(7, 3) == 8);
  }
}
