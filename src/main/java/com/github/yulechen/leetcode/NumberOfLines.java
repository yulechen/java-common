package com.github.yulechen.leetcode;

/**
 * https://leetcode-cn.com/problems/number-of-lines-to-write-string/
 */
public class NumberOfLines {


  public static void main(String[] args) {
    int[] widths = {10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10};
    String S = "abcdefghijklmnopqrstuvwxyz";

    int[] ints = numberOfLines2(widths, S);
    for (int i : ints) {
      System.out.print(""+i+" ");
    }
    System.out.println();
    int[] widths2={4,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10};
    String S2 = "bbbcccdddaaa";
    ints = numberOfLines2(widths2, S2);
    for (int i : ints) {
      System.out.print(""+i+" ");
    }

  }

  public static int[] numberOfLines(int[] widths, String S) {
    int[] result = new int[2];
    int[] charLength = new int[127];
    for (int i = 'a', j = 0; i <= 'z'; i++, j++) {
      charLength[i] = widths[j];
    }
    char[] chars = S.toCharArray();
    int currentCount = 0;
    int lines=1;
    for (int i=0;i<chars.length;i++) {
       currentCount=currentCount+charLength[chars[i]];
       if(currentCount>100){
         lines++;
         // 回溯i
         i=i-1;
         currentCount=0;
       }
    }
    result[0]=lines;
    result[1]=currentCount;
    return result;
  }



  public static int[] numberOfLines2(int[] widths, String S) {
    int[] result = new int[2];
    char[] chars = S.toCharArray();
    int currentCount = 0;
    int lines=1;
    for (int i=0;i<chars.length;i++) {
      currentCount=currentCount+widths[chars[i]-97];
      if(currentCount>100){
        lines++;
        currentCount=widths[chars[i]-97];
      }
    }
    result[0]=lines;
    result[1]=currentCount;
    return result;
  }

}
