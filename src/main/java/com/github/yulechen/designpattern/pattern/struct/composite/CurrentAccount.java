package com.github.yulechen.designpattern.pattern.struct.composite;

/**
 * @Author: chenq
 * @Date: 2020/3/25  14:41
 */
public class CurrentAccount implements Account {

  @Override
  public void accountType() {
    System.out.println("current Acconut");
  }
}
