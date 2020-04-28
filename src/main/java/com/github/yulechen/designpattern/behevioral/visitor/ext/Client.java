package com.github.yulechen.designpattern.behevioral.visitor.ext;

/**
 * @Author: chenq
 * @Date: 2020/4/28  15:27
 */
public class Client {


  public static void say(Parent obj){
    System.out.println("match parent");
    obj.say();
  }

  public static void say(Sub obj){
    System.out.println("match sub");
    obj.say();
  }

  // single-dispatch,只依据编译时期匹配重载方法。不依据运行时具体类型匹配方法。
  public static void main(String[] args) {
      Parent p =new Parent();

      p =new Sub();
      say(p);

  }
}
