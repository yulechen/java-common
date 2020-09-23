package com.github.yulechen.datastruct.algorithm.recursion.resurion3;

import java.util.Stack;

public class RevertString {


  public static void main(String[] args) {
    String str ="123你好456";
    System.out.println(revertByStack(str));
    System.out.println(revertByRecursion(str));
  }

  /**
   *
   * 逆序遍历
   * @param str
   * @return
   */
  static String  revertByStack(String str){
    if(null == str ||str.isEmpty()){
      return str;
    }
    Stack<Character> stack = new Stack<>();
    char[] chars = str.toCharArray();
    for (char aChar : chars) {
      stack.push(aChar);
    }
    StringBuilder sb = new StringBuilder();
    while (!stack.isEmpty()){
      sb.append(stack.pop());
    }
    return sb.toString();
  }

  /**
   * 递归解析
   * @param str
   * @return
   */
  static String revertByRecursion(String str){
    if(null == str ||str.isEmpty()){
      return str;
    }
    // 第一次返回
    if(str.length()==1){
      return str;
    }
    return revertByRecursion(str.substring(1))+str.charAt(0);
  }


}
