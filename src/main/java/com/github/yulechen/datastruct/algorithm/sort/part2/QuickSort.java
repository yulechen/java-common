package com.github.yulechen.datastruct.algorithm.sort.part2;

import com.github.yulechen.datastruct.algorithm.sort.Sort;

public class QuickSort extends Sort {

  @Override
  public void sort(int[] a, int n) {
    quickSort(a,0,n-1);
  }


  public void quickSort(int[] a, int start,int end) {
      if(start>=end){
         return ;
      }
      int  q=partition0(a,start,end);
      quickSort(a,start, q-1);
      quickSort(a,q+1 ,end);
  }

  // 非原地排序
  private int partition(int[] a, int start, int end) {
    // last element
    int pivot= a[end];
    //
    int x[] =new int[a.length];
    int xIndex=0,yIndex=0;
    int y[] =new int[a.length];
    for(int i=start;i< end;i++){
      if(a[i]<pivot){
        x[xIndex++]=a[i];
      }else{
        y[yIndex++]=a[i];
      }
    }
    // copy <
    int k=start;
    for(int i =0;i<xIndex;i++){
      a[k++]=x[i];
    }
    // copy =
    int q=k;
    a[k++]=pivot;
    // copy > =
    for(int i=0;i<yIndex;i++){
      a[k++]=y[i];
    }
    return q;
  }

  // 使用选择排序思想 ，已处理区间，为处理区间
  private int partition0(int[] a, int start, int end) {
    int pivot= a[end];
    // i 比 pivot 小
    // i 是比 pivot 小的索引
    //  j 是循环迭代。
    int i =start;
    for(int j=start;j<end;j++){
       if(a[j] < pivot){
         int temp= a[i];
         a[i]=a[j];
         a[j]=temp;
         i++;
       }
    }
    a[end]=a[i];
    a[i]= pivot;
    return i;

  }

  public static void main(String[] args) {
    int a[] ={9,2,2,6,1};
  // int a[] ={9,4,5,6,3,2,2,33,1};
    QuickSort m = new QuickSort();
    m.sort(a,a.length);
    m.printArray(a,0);
  }
}
