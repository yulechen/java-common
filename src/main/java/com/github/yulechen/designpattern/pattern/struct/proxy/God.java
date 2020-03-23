package com.github.yulechen.designpattern.pattern.struct.proxy;

/**
 * @Author: chenq
 * @Date: 2020/3/23  09:55
 */
public class God {

  public static void main(String[] args) {

    BadDesign design =new BadDesign();
    // execute login,and record log
    design.login("1","2");

    // execute login,and record log
    design.register("1","2");

  }

}
