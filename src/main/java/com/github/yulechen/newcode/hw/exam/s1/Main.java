package com.github.yulechen.newcode.hw.exam.s1;

import java.util.Scanner;

public class Main {


  public static void main(String[] args) {
    //int[] test1={123, 124 ,125, 121 ,119 ,122 ,126, 123};
    Scanner in = new Scanner(System.in);
    while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
      int length = in.nextInt();
      int[] input =new int[length];
      for(int i =0 ;i< length;i++){
        input[i]=in.nextInt();
      }
      int[] frieds = getFrieds(input);
      for(int i =0 ;i< frieds.length;i++){
        System.out.print(frieds[i]);
        if(i != frieds.length-1){
          System.out.print(" ");
        }
      }
    }
    in.close();
  }


  static int[] getFrieds(int[] height){
    int[] f =  new int[height.length];
    for(int i =0 ;i < height.length ;i++){
        int curr= height[i];
        for(int j=i+1;j<height.length;j++){
           if(height[j]>curr){
             f[i]=j;
             break;
           }
        }
    }
   return f;
  }
}
