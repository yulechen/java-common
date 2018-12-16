package com.github.yulechen.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Permute {


  /**
   * nums.length=3
   */

  public static List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> allTurn = new ArrayList<>();
    List<Integer> integers = converIntToInteger(nums);
    for (int i = 0; i <integers.size() ; i++) {
      List<Integer> swapNum = swapIndex(integers.size()-1, i, integers);
      permuteList(allTurn, swapNum, 0);
    }

    return allTurn;
  }


  private static void permuteList(List<List<Integer>> allTurn, List<Integer> nums, int start) {
    int end = nums.size();
    if (end - start <= 2) {
      for (int i = start; i < end; i++) {
        allTurn.add(swapIndex(start, i, nums));
      }
      return;
    } else {
      List<Integer> integers = swapIndex(start, 0, nums);
      permuteList(allTurn, integers, start + 1);
    }
  }

  public static List<Integer> converIntToInteger(int[] src) {
    List<Integer> re = new ArrayList<>();
    for (int i = 0; i < src.length; i++) {
      re.add(src[i]);
    }
    return re;
  }


  public static List<Integer> swapIndex(int index1, int index2, List<Integer> source) {
    Integer integerIndex1 = source.get(index1);
    Integer integerIndex2 = source.get(index2);
    source.set(index2, integerIndex1);
    source.set(index1, integerIndex2);
    List<Integer> r = new ArrayList<>();
    for (Integer integer : source) {
      r.add(integer);
    }
    return r;


  }


  public static void main(String[] args) {
    int[] src = {1,2,3,4};
    List<List<Integer>> permute = permute(src);
    int size = permute.size();
    System.out.println(size); // 4*3*2*1
    permute.forEach(System.out::println);


  }

}
