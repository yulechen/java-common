package com.github.yulechen.newcode.hw.simple;

public class MinBeishu {


  public static void main(String[] args) {
    System.out.println(papulate(2, 4));
  }

  static int papulate(int a ,int b){
    for(int i=1 ;i<=b;i++){
      int temp =i*a;
      if(temp%b==0){
        return temp;
      }
    }
    return a*b;
  }
}
