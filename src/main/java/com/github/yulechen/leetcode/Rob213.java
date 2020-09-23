package com.github.yulechen.leetcode;

public class Rob213 {


  public static int rob(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }
    if (nums.length == 1) {
      return nums[0];
    }
    int max = 0;
    for (int i = 0; i < nums.length; i++) {
      int sum = 0;
      for (int j = i; j < nums.length; j = j + 2) {
       if((j+1)%nums.length!=i)
          sum = sum + nums[j];
      }
      max = max > sum ? max : sum;
    }
    // 最后一个元素
    int sum=nums[nums.length-1];
    for(int i =1;i<nums.length-1;i=i+2){
      if((i+1)%nums.length!=i)
        sum=sum+nums[i];
    }
    max = max > sum ? max : sum;

    return max;
  }

  public static void main(String[] args) {
    int[] a = {2, 3, 2};
    int[] b = {1, 2, 3, 1};
    int[] c = {1};
    int[] d = {1, 2};
    int[] e = {1, 3,1,3,100};
    System.out.println(rob(a));
    System.out.println(rob(b));
    System.out.println(rob(c));
    System.out.println(rob(d));
    System.out.println(rob(e));
  }

}
