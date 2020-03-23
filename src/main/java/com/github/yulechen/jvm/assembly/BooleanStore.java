package com.github.yulechen.jvm.assembly;

/**
 * @Author: chenq
 * @Date: 2020/1/13  10:49
 */
public class BooleanStore {

  // boolean 字段 默认大小为字节，且取最后一位
  // boolean 栈 默认大小为int ，会做扩展
  static boolean boolValue;

  public static void main(String[] args) {
    boolValue = true; // 将这个true替换为2或者3，再看看打印结果

    if (boolValue) {
      System.out.println("Hello, Java!");
    }
    if (boolValue == true) {
      System.out.println("Hello, JVM!");
    }
  }
}
