package com.github.yulechen.datastruct.algorithm.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: chenq
 * @Date: 2020/6/1  17:27
 * 求值过程在递的部分
 */
public class Permutate_00 {

  // 求 5的全排列组合情况
  // 5!= 5x4!
  // 递推公式现成的，代码写起来就比较简单
  public static void main(String[] args) {
    System.out.println(permutate(5));
    System.out.println(permutateLoop(5));
    List<Integer> integers = Arrays.asList(new Integer[]{1, 2, 3, 4, 5});
    permutateDetail(new ArrayList<Integer>(integers),new ArrayList<>());
  }

  //1 、求值
  // 2这还是一个尾递归
  // 尾递归一般可以改写成循环，循环的话一般从下往上汇总
  static int permutate(int number) {
    if (number == 1) {
      return 1;
    }
    return permutate(number - 1) * number;
  }

  static int permutateLoop(int number) {
    int result=1;
    for(int i=1;i<=number;i++){
      result=result*i;
    }
    return result;
  }

  // 2、求明细
  static void permutateDetail(ArrayList<Integer> numbers,ArrayList<Integer> result) {
    // 终止条件
    if(numbers.size()==0){
      System.out.println(result);
    }
     // 路径详情在递的阶段设置
    for (int i = 0; i < numbers.size(); i++) {
      Integer integer = numbers.get(i);
      ArrayList<Integer> tempResult= new ArrayList<>();
      tempResult.add(integer);
      tempResult.addAll(result);
      ArrayList numberBack = (ArrayList<Integer>)numbers.clone();
      numberBack.remove(i);
      permutateDetail(numberBack,tempResult);
    }


  }

}
