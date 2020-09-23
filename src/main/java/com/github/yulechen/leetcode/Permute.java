package com.github.yulechen.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Permute {




  public static List<List<Integer>> permute4( List<Integer> integers) {
    List<List<Integer>> allTurn = new ArrayList<>();
    int size =integers.size();
    for(int a=0;a<size;a++){ // 0-3
      List<Integer> swapNum1 = swapIndex(0, a, integers);
      for(int i=1 ;i<size;i++){ // 1-3
        List<Integer> swapNum = swapIndex(1, i, swapNum1);
        for(int j=2;j<size;j++){  // 2-3
          List<Integer> integers1 = swapIndex(2, j, swapNum);
          allTurn.add(integers1);
        }
      }
    }

    return allTurn;
  }

  static List<List<Integer>> gloablTurn = new ArrayList<>();

  public static void childPermute(int index,List<Integer> integers) {
      for(int a=index;a<integers.size();a++){
          List<Integer> swapNum1 = swapIndex(index, a, integers);
          if(index==integers.size()-1){
            gloablTurn.add(swapNum1);
            return;
          }
          childPermute(index+1,swapNum1);
      }
  }


  /**
   *
   *  一直remove一个元素，用剩下的来全排列。
   *
   *
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
    int[] src = {1,2,3};
//    List<Integer> integers = converIntToInteger(src);
//    List<List<Integer>> permute = permute4(integers);
//    int size = permute.size();
//    System.out.println(size);
//    permute.forEach(System.out::println);


    List<Integer> integer1 = converIntToInteger(src);
    childPermute(0,integer1);

    int size = gloablTurn.size();
    System.out.println(size);
    gloablTurn.forEach(System.out::println);
  }

}
