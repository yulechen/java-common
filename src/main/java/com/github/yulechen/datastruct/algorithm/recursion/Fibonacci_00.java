package com.github.yulechen.datastruct.algorithm.recursion;

import java.util.HashMap;
import java.util.Map;

/**
 * F(1)=1，F(2)=1, F(n)=F(n - 1)+F(n - 2)（n ≥ 3，n ∈ N*） 例如： 1、1、2、3、5、8、13、21、34
 *
 * @Author: chenq
 * @Date: 2020/6/1  14:04
 */
public class Fibonacci_00 {

  public static void main(String[] args) {

    System.out.println(fib(4));
    Map<Integer, Integer> history = new HashMap<>();
    fibDetail(9, history);
    System.out.println(history.values());
  }


  // 1、求最后值
  static int fib(int i) {
    if (i == 1 || i == 2) {
      return 1;
    }
    return fib(i - 1) + fib(i - 2);
  }

  // 求数列所有值
  // 去掉重复计算的值
  static int fibDetail(int i, Map<Integer, Integer> history) {
    if (history.containsKey(i)) {
      return history.get(i);
    }
    if (i == 1 || i == 2) {
      // 第一步返回值->归
      // 最后一步递
      history.put(i, 1);
      return 1;
    }
    // 递拆分过程，改变参数值
    int fi = fibDetail(i - 1, history) + fibDetail(i - 2, history);
    // 返回值->归
    history.put(i, fi);
    return history.get(i);
  }


}
