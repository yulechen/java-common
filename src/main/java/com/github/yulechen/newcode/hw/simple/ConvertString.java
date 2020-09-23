package com.github.yulechen.newcode.hw.simple;

import java.util.Scanner;

public class ConvertString {

  public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      while(sc.hasNext()){
        String line= sc.nextLine();
        System.out.println(convert(line));
      }
      sc.close();

  }

  private static String convert(String line) {
    char[] chars = line.toCharArray();
    int len= chars.length;
    char[] temp =new char[len];
    for(int i = 0 ;i<len;i++){
      temp[i]=chars[len-1-i];
    }
    return new String(temp);
  }

}
