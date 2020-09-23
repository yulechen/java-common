package com.github.yulechen.newcode.hw.middle;

import java.util.Scanner;

public class CountDiffChar {


  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while(sc.hasNext()){
      String v = sc.nextLine();
    }
    sc.close();
    System.out.println(count("abdcdds"));
  }



  static int count(String str){
    char[] chars = str.toCharArray();
    char[] counter =new char[128];
    for (char aChar : chars) {
      counter[aChar]=1;
    }
    int sum=0;
    for (char c : counter) {
      if(c==1)sum++;
    }
    return sum;
  }
}
