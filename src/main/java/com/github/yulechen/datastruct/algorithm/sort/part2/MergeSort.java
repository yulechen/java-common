package com.github.yulechen.datastruct.algorithm.sort.part2;

import com.github.yulechen.datastruct.algorithm.sort.Sort;

public class MergeSort  extends Sort {

  @Override
  public void sort(int[] a, int n) {
    mergeSort(a,0,n-1);
  }


  public void mergeSort(int[] a ,int start ,int end){
       if(start>= end){
         return ;
       }
       int mid= (start+end)/2;
       // 先排序，后拆分，就是快排

       mergeSort(a,start,mid);
       mergeSort(a,mid+1,end);
       // 数据返回时，进行排序
       merge(start,mid,end,a);
  }


  /**
   *
   * @param start
   * @param mid
   * @param end
   * @param a
   */
  public void merge(int start,int mid,int end,int[] a){
      // start part1
      int i = start;
      // start part2
      int j= mid+1;
      // temp array
      int k = 0;
      int[] temp= new int[end-start+1];

      // 依次比较大小  N
      while(i<=mid && j<=end){
        if(a[i]<a[j]){
          temp[k++]= a[i++];
        }else{
          temp[k++]= a[j++];
        }
      }

      // 判断剩余数组
      int s1= i;
      int s2=mid;
      if(i>mid){
        s1 =j;
        s2= end;
      }

      while(s1<=s2){
         temp[k++]= a[s1++];
      }
      // copy to source array;
      // 数组开始的地方 复制
      for(int l =0 ;l<temp.length;l++){
         a[start+l]=temp[l];
      }

  }

  public static void main(String[] args) {
    int a[] ={9,4,5,6,3,2,2,33,1};
    MergeSort m = new MergeSort();
    m.sort(a,a.length);
    m.printArray(a,0);
  }



}
