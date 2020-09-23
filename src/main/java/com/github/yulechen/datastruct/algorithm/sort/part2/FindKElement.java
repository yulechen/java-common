package com.github.yulechen.datastruct.algorithm.sort.part2;

/**
 *  查找第K 大的元素，利用快排的分区思想
 * 4， 2， 5， 12， 3
 */
public class FindKElement {

  /**
   * 找到一个满足条件就放在i 的位置，原来i 位置的元素交换到j上面去。
   * @param a
   * @param start
   * @param end
   * @return
   */
  static int partition(int[] a,int start, int end){
    int p = a[end];
    int i= start;
    for(int j = start ;j<end;j++){
      int temp = a[j];
       if(temp<p){
         a[j]=a[i];
         a[i]=temp;
         i++;
       }
    }
    a[end]=a[i];
    a[i]=p;
    return i;
  }

  /**
   * 在数组中找第2大的元素
   * @param a
   * @param k
   * @return
   */
  static int findK(int[] a ,int start,int end ,int k){
    if(start>=end){
      if(start == k-1){
        return a[start];
      }
      return -1;
    }
    int p = partition(a, start, end);
    if(p==(k-1)){
      return a[p];
    }
    int k1 = findK(a, start, p - 1, k);
    if(k1>=0){
     return k1;
    }
    return findK(a,p+1 ,end,k);
  }

  public static void main(String[] args) {
    int a[] ={3,9,2,5,6,8};
    System.out.println(findK(a, 0, a.length - 1, 5));
    printArray(a,0);
  }
  static   void printArray(int[] a ,int i){
    System.out.print("第"+i+"趟： ");
    for (int k : a) {
      System.out.print(k+" ");
    }
    System.out.println();
  }
}
