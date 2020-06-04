package com.github.yulechen.datastruct.algorithm.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: chenq
 * @Date: 2020/6/1  16:47
 */
public class JiangJin_00 {
  public static int[] rewards = {1, 2, 5, 10};  // 四种面额的纸币

  //  面值 ：1 元、2 元、5 元和 10 元
  //  总额：10 元
  //  有多少种可能
  public static void main(String[] args) {
    //System.out.println(reward(10));
    System.out.println(rewardDetail(10, new ArrayList<>()));
  }

  // 求总值
  // 10 元 的上一步总数为  10 -1，10-2，。。。
  // 金额为0 时满足条件
  static int reward(int total){
    if(total==0){
      return 1;
    }else if (total<0){
      return 0;
    }
    int totalCount=0;
    // f(n)=f(n-10)+f(n-5)+f(n-2)+f(n-1)
    // f(0)=1
    return reward(total-1)+reward(total-2)+reward(total-5)+reward(total-10);
  }

  /**
   * 求明细
   * @param total
   * @param perDetail
   * @return
   */
  static int rewardDetail(int total, List<Integer> perDetail){
    if(total==0){
      System.out.println(perDetail);
      return 1;
    }else if (total<0){
      return 0;
    }
    int totalCount=0;
    // f(n)=f(n-10)+f(n-5)+f(n-2)+f(n-1)
    // f(0)=1
    // 递阶段拆分参数，记录拆分值。
    List<Integer> y1List= new ArrayList<>();
    y1List.add(1);
    y1List.addAll(perDetail);
    List<Integer> y2List= new ArrayList<>();
    y2List.add(2);
    y2List.addAll(perDetail);
    List<Integer> y5List= new ArrayList<>();
    y5List.add(5);
    y5List.addAll(perDetail);
    List<Integer> y10List= new ArrayList<>();
    y10List.add(10);
    y10List.addAll(perDetail);

    int y1= rewardDetail(total-1,y1List);
    int y2= rewardDetail(total-2,y2List);
    int y5= rewardDetail(total-5,y5List);
    int y10= rewardDetail(total-10,y10List);
    return y1+y2+y5+y10;
  }







  public static void get(long totalReward, ArrayList<Integer> result) {

    // 当totalReward = 0时，证明它是满足条件的解，结束嵌套调用，输出解
    if (totalReward == 0) {
      System.out.println(result);
      return;
    }
    // 当totalReward < 0时，证明它不是满足条件的解，不输出
    else if (totalReward < 0) {
      return;
    } else {
      for (int i = 0; i < rewards.length; i++) {
        ArrayList<Integer> newResult = (ArrayList<Integer>)(result.clone());  // 由于有4种情况，需要clone当前的解并传入被调用的函数
        newResult.add(rewards[i]);            // 记录当前的选择，解决一点问题
        get(totalReward - rewards[i], newResult);    // 剩下的问题，留给嵌套调用去解决
      }
    }

  }

}
