package com.github.yulechen.datastruct.algorithm.recursion;

/**
 * @Author: chenq
 * @Date: 2020/6/1  16:25
 *
 * 可以走，1，2，3 次台阶
 */
public class ZhouTaiJie_02 {

  public static void main(String[] args) {
    System.out.println(step(5));
  }

  /**
   *
   * 1、求结果
   * @param n : 台阶数
   * @return ： 走法
   * n>=3
   */
  static int step(int n){
    if(n==1){
      return 1;
    }
    if(n==2){
      return 2;
    }
    if(n==3){
      return 4;
    }
    int k1= step(n-1);
    int k2= step(n-2);
    int k3= step(n-3);
    return k1+k2+k3;
  }
}
