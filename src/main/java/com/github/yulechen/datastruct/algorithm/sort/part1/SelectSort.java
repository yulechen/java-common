package com.github.yulechen.datastruct.algorithm.sort.part1;

import com.github.yulechen.datastruct.algorithm.sort.Sort;

public class SelectSort  extends Sort {


  /**
   * 分为排序区间，未排序区间
   *
   * @param a
   * @param n
   */

  public void sort(int[] a, int n) {
    for(int i = 0;i<n;i++){ // 趟数
      int min =a[i];
      for(int j =i+1;j<n;j++){
          if(min>a[j]){ // select min and swap
             int temp = min;
             min=a[j];
             a[j]=temp;
          }
      }
      a[i]=min;
      printArray(a,i);
    }


  }

  public static void main(String[] args) {
    int a[] ={4,5,6,3,2,1};
    SelectSort ss = new SelectSort();
    ss.sort(a,a.length);

  }
}
