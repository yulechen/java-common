package com.github.yulechen.leetcode.meituan;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @Author: chenq
 * @Date: 2019/8/20  上午11:28
 */
public class Meituan01 {


  static String[][] a={
      {"a","b","c","d"},
      {"e","f","g","h"},
      {"m","n","o","p"},
      {"q","r","s","t"}
  };


  public static void main(String[] args) {
    int n =a.length;
    StringBuffer sb =new StringBuffer();
    for (int i =0 ;i<n;i++){
      for(int j=i;j>=0;j--)
        sb.append(a[i-j][j]);
    }
    int start=1;
    int end=n-1;
    for(int i=end;i>=start;i--){
       int start2=end-i+1;
       int end2=end;
       int total = start2+end2;
      for (int j = start2; j <= end; j++)
         sb.append(a[j][total-j]);
    }
    System.out.println(sb);
    System.out.println(sb.toString().equals("abecfmdgnqhorpst"));
    show2();

  }

  public static void show2() {
    Map<Integer,ArrayList> m  = new LinkedHashMap<>();
    int n =a.length;
    for (int i = 0; i <n ; i++) {
      for (int j = 0; j <n ; j++) {
          if(m.get(i+j)==null){
            m.put(i+j,new ArrayList<>());
          }
          m.get(i+j).add(a[i][j]);
      }
    }
    System.out.println(m);
  }


}
