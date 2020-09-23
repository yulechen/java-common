package com.github.yulechen.newcode.hw;

import java.util.Scanner;

public class FloatNumber {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while(sc.hasNext()){
      float v = sc.nextFloat();
      System.out.println(Math.round(v));

    }
    sc.close();
  }
}
