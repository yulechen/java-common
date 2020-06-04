package com.github.yulechen.datastruct.algorithm.recursion;

import java.util.ArrayList;

/**
 * @Author: chenq
 * @Date: 2020/6/1  14:48
 *
 * 问题描述： 假如这里有 n 个台阶，每次你可以跨 1 个台阶或者 2 个台阶，请问走这 n 个台阶有多少种走法？ 例如：有 7 个台阶，你可以 2，2，2，1 这样子上去
 *
 * 分析： 假如 7 个台阶  ，前面已经走了n-1,n-2
 *
 * 递归： 7 - 6 - 5 4 3 4 3 2 1 2 1 0 5 4 3
 */
public class ZhouTaiJie_01 {

  static ArrayList<Integer> numbers = new ArrayList<>();
  static int deepth = 0;

  static {
    numbers.add(1);
    numbers.add(2);
  }

  /**
   * 1、求结果
   *
   * @param n : 台阶数
   * @return ： 走法
   */
  static int step(int n) {
    if (n == 1) {
      return 1;
    }
    if (n == 2) {
      return 2;
    }
    int k1 = step(n - 1);
    int k2 = step(n - 2);
    return k1 + k2;
  }

  /**
   * 1、求明细 2、规模降低 3 个台阶走法 3、排列组合问题
   */

  static void stepDetail(int n,ArrayList<Integer> perDetail) {
    if (n == 1) {
      perDetail.add(1);
      System.out.println(perDetail);
      return ;
    }
    if (n == 2) {
      ArrayList list1 = (ArrayList<Integer>)perDetail.clone();
      list1.add(1);
      list1.add(1);
      System.out.println(list1);

      ArrayList list2 = (ArrayList<Integer>)perDetail.clone();
      list2.add(2);
      System.out.println(list2);
      return ;
    }

    ArrayList list1 = new ArrayList();
    list1.add(1);
    list1.addAll(perDetail);

    ArrayList list2 = new ArrayList();
    list2.add(2);
    list2.addAll(perDetail);

    stepDetail(n-1,list1);
    stepDetail(n-2,list2);
  }




  static int sum(ArrayList<Integer> result) {
    return result.stream().mapToInt(t -> t).sum();
  }

  public static void main(String[] args) {
    // int step=4;
    //  System.out.println("总台阶数sum："+step);
    //  System.out.println("计算总数："+step(step));
    stepDetail(7,new ArrayList<>());

  }
}
