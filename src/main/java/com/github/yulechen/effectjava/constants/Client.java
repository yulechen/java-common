package com.github.yulechen.effectjava.constants;

/**
 * @Author: chenq
 * @Date: 2019/7/11  上午11:20
 */
public class Client {


  public static void main(String[] args) {
    // if IntConstants.a 的值修改后，不重新编译client ，client 的值不会发生变化

    System.out.println("INT Constants:"+IntConstants.a);
    // if EnumConstants.a 的值修改后，不重新编译client ，client 的值不发生变化
    System.out.println("EnumConstants:"+EnumConstants.a.getV());
  }

  /**
   *  JLS, 4.12.4,JLS, 13.1
   *  compile code
   * public static void main(String[] args) {
   *    System.out.println("INT Constants:1");
   *    System.out.println("EnumConstants:" + EnumConstants.a.getV());
   *  }
   */
}
