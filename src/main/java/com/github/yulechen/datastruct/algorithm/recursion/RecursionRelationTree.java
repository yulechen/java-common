package com.github.yulechen.datastruct.algorithm.recursion;

/**
 * @Author: chenq
 * @Date: 2020/6/2  11:23
 * 递归与树的关系
 *
 */
public class RecursionRelationTree {



  /**
   * 函数模板
   * @param number
   * 1、递归函数转换为树
   * 2、树转换为递归函数
   *
   */
  public void f(int number){
    // 终止条件
    if(number ==1){
       return ;
    }
    // 问题拆分-递的部分
    f(number-3);
    f(number-2);
    f(number-1);

    // 归的部分
  }
}
