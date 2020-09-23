package com.github.yulechen.datastruct.algorithm.sort.part1;

public class BubbleSort {


  public static void main(String[] args) {

   int a[] ={4,5,6,3,2,1};
  // int b[] ={1,2,3,4,5,6};
   bubbleSort(a,a.length);

  }


  static void bubbleSort(int[] a, int n){
    for(int i =0 ;i< n ;i++){ // 排几次
      boolean hasCompare=false; // 如果一趟排序，没有交换操作，说明排序完成。
         for(int j =0 ;j<n-i-1;j++){ // 具体排序
              int c= a[j];
              int next= a[j+1];
              if(c > next){ // 是否用等于
                a[j+1]=c;
                a[j]=next;
                hasCompare=true;
              }
          }
          printArray(a,i);
          if(!hasCompare){
             break;
          }
    }

  }

  static void printArray(int[] a ,int i){
    System.out.print("第"+i+"趟： ");
    for (int k : a) {
      System.out.print(k+" ");
    }
    System.out.println();
  }
}
