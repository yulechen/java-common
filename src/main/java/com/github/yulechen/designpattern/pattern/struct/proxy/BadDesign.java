package com.github.yulechen.designpattern.pattern.struct.proxy;

/**
 * @Author: chenq
 * @Date: 2020/3/23  09:48
 *
 * #1、问题，代码重复太多，业务代码与非业务代码交替使用
 *
 */
public class BadDesign {

  void login(String name,String password){
    long startTimestamp = System.currentTimeMillis();
    // TODO



    long endTimeStamp = System.currentTimeMillis();
    long responseTime = endTimeStamp - startTimestamp;
    System.out.println(responseTime);
  }

  void register(String name,String password){
    long startTimestamp = System.currentTimeMillis();
    // TODO


    long endTimeStamp = System.currentTimeMillis();
    long responseTime = endTimeStamp - startTimestamp;
    System.out.println(responseTime);

  }

  // TODO 每个方法类似结构



}
