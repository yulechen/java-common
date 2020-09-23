package com.github.yulechen.datastruct.algorithm.sort.part1;

import com.github.yulechen.datastruct.algorithm.sort.Sort;

public class InsertSort  extends Sort {

  public static void main(String[] args) {
    int a[] ={4,5,6,3,2,1};
    InsertSort s= new InsertSort();
    s.insertionSort(a,a.length);

  }

  @Override
  public void sort(int[] a, int n) {
     if (n <= 1) return;
      for(int i =1 ;i< n ;i++){
         int c= a[i];
         // look for insert position
         // and move to element;

        // 技巧： 移动元素，从后面开始移动
        // bug , 第一个元素
         for(int j=i-1;j>=0;j--){
             if(c>a[j] ){ // find and move
               a[j+1]=c;
               break;
             }else{
               a[j+1]=a[j];
             }
             if(j==0){
                a[j]=c;
             }
         }
         printArray(a,i);
      }
  }


  // 插入排序，a表示数组，n表示数组大小
  public void insertionSort(int[] a, int n) {
    if (n <= 1) return;

    for (int i = 1; i < n; ++i) {
      int value = a[i];
      int j = i - 1;
      // 查找插入的位置
      for (; j >= 0; j--) {
        if (a[j] > value) {
          a[j+1] = a[j];  // 数据移动
        } else {
          break;
        }
      }
      System.out.println("j:"+j);
      a[j+1] = value; // 插入数据
      printArray(a,i);
    }
  }
}
