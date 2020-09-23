package com.github.yulechen.leetcode;

import java.util.ArrayList;
import java.util.List;


public class ThreeNumbers {

  public static void main(String[] args) {
    int[] nums = {-1, 0, 1, 2, -1, -4};
    List<List<Integer>> lists = threeSum(nums);
    lists.forEach(t->{
      System.out.println(t);
    });
  }


  /**
   * 循环方式做 +穷举
   * @param nums
   * @return
   */
  public static List<List<Integer>> threeSum(int[] nums) {
       List<List<Integer>> result =new ArrayList<>();
        for(int i=0;i<nums.length;i++){
          int a= nums[i];
          int[] remove1 = remove(nums, i);
          for(int j =0;j< remove1.length;j++){
                int b =  remove1[j];
                int[] remove2 = remove(nums, j);
                for(int k =0;k< remove2.length;k++){
                  int c = remove2[k];
                  if(a+b+c==0){
                    List<Integer> integers =new ArrayList<>();
                    integers.add(a);
                    integers.add(b);
                    integers.add(c);

                    result.add(integers);

                  }
                }
           }
        }
        return result;
  }


  public static int[] remove(int[] nums ,int index){
    int[] newNums = new int[nums.length-1];
    for(int i= 0 ;i< index;i++){
      newNums[i]=nums[i];
    }
    for(int i= index ;i< newNums.length;i++){
      newNums[i]=nums[i+1];
    }
    return newNums;
  }

  public  static  void printArray(int[] array){
    for (int i : array) {
      System.out.print(i+" ");
    }
    System.out.println();
  }
}
