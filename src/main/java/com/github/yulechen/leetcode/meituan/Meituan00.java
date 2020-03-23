package com.github.yulechen.leetcode.meituan;

/**
 * @Author: chenq
 * @Date: 2019/8/26  上午10:44
 */
public class Meituan00 {


  public static void main(String[] args) {
    int n=5;
    char[][] p=new char[n][n];
    int half=n/2;
    int count=0;
    int start =0;
    for (int i = 0; i <n ; i++) {
      if(i<=half){
        count=2*i+1;
        start = half-i;
      }else{
        count=2*(n-i)-1;
        start = i-half;
      }
      for (int j=0;j<n;j++){
          if(j>=start && j<start+count)
            p[i][j]='*';
          else
            p[i][j]=' ';
        System.out.print(p[i][j]);
      }
      System.out.println();
    }
  }


}
