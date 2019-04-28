package com.github.yulechen.effectjava.classesandinfterfaces.item18;

import java.util.Arrays;

public class ClientA {

  public static void main(String[] args) {
    ClassBOptimizingInstrumente optimizingGetCount = new ClassBOptimizingInstrumente();
    optimizingGetCount.addAll(Arrays.asList("b", "c"));
    // the output is error when use inheritance
    // overwrite maybe error
    System.out.println(optimizingGetCount.getCount());

  }
}
