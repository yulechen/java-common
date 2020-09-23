package com.github.yulechen.newcode.hw;

import java.util.Scanner;

public class ZhouGeZhi {


  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while(sc.hasNext()){
      int num1= sc.nextInt();
      int num2= sc.nextInt();
      System.out.println(go(num1,num2));
    }
    sc.close();
  }



  /**
   * @param n ,横向格子数
   * @return 总共多少种走法
   */

  /**
   *
   * @param n
   * @param m
   * @param nn  [0-n]
   * @param mm  [0-m]
   * @return
   */
  static int go(int n,int m){
    return doGo(n,m,0,0);
  }


  /**
   * 回溯算法
   * @param n
   * @param m
   * @param nn
   * @param mm
   * @return
   */
  static int doGo(int n, int m,int nn,int mm) {
    // 算一种走法
    if(nn==n && mm==m){
        return 1;
    }else if(nn >n || mm>m){
       return 0;
    }
    return doGo(n,m,nn+1,mm)+doGo(n,m,nn,mm+1);
  }




}
