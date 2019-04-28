package com.github.yulechen.effectjava.classesandinfterfaces.item18;

import java.util.Arrays;

public class ClientB {

  public static void main(String[] args) {
    ClassA a= new ClassA();
    ClassCOptimizingInstrumente optimizingGetCount = new ClassCOptimizingInstrumente(a);
    optimizingGetCount.addAll(Arrays.asList("b", "c"));
    System.out.println(optimizingGetCount.getCount());
  }
}
