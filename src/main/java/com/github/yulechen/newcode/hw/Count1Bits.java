package com.github.yulechen.newcode.hw;

import java.util.Scanner;

public class Count1Bits {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while(sc.hasNext()){
      int num= sc.nextInt();
      System.out.println(count(num));
    }
    sc.close();
  }

  static int count(int number){
     int sum=0;
     while(number>0){
       if((number & 0x01)==1){
         sum++;
       }
       number = number>>1;
     }
     return sum;
  }
}
