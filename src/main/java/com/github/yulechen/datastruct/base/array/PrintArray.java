package com.github.yulechen.datastruct.base.array;

/**
 * 斜线打印二维数组
 *
 */
public class PrintArray {

  public static void main(String[] args) {

    char a[][] = {
        {'a','b','c','d'},
        {'e','f','g','h'},
        {'m','n','o','p'},
        {'q','r','s','t'},
    };

    printArray(a);
  }


  static void printArray(char a[][]){
    for(int k =0 ;k<a.length;k++){
      for(int i =0 ;i<=k;i++){
        System.out.print(a[i][k-i] +" ");
      }
      System.out.println();
    }
    int col =a[0].length;
    for(int k =1 ;k< a.length;k++){
       for(int i =k ;i<col;i++){
         int index =i-k;
         System.out.print(a[i][col-1-index]+" ");
       }
      System.out.println();
    }

  }

}
