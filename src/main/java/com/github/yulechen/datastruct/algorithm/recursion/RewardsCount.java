package com.github.yulechen.datastruct.algorithm.recursion;

/**
 * @Author: chenq
 * @Date: 2020/5/12  11:42
 *
 * 求奖励方案可能的总次数
 * 求10元， 上一步结果 ：分解为求 9，8，5，1
 * 求 9，8，5，1 ，分解为：【8，7，4，-1】，【7，6，3，-2】，【4，3，（0），-5】，【（0），-1，-4，-9】
 *
 */
public class RewardsCount {
  // 四种面额的纸币
  public static long[] rewards = {1, 2, 5, 10};

  static int totalCount =0;

  public static void get(long totalReward) {
    // 到达最底层
    if(totalReward==0){
      totalCount++;
      return ;
    }else if(totalReward<=0){
      return ;
    }
    for (long reward : rewards) {
      // 倒数第一步已经好了 ,计算每一个，可以求出
      get(totalReward-reward);
    }
    return ;
  }


  public static void main(String[] args) {
    get(10);
    System.out.println(totalCount);

  }


}
