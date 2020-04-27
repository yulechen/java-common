package com.github.yulechen.designpattern.behevioral.command.v0;

import com.github.yulechen.designpattern.behevioral.command.Command;

/**
 * @Author: chenq
 * @ invoker
 * # 可以执行任意命令
 *
 * @Date: 2020/4/27  17:15
 */
public class MenuItem {

  // 1、receiver 1 -- paste
  // 2、receiver 1  -- open
  // 3、receiver 1  - cut
  // receiver 没有通用的接口或者共同的父类
  private Command command;

  public MenuItem(Command command) {
    this.command = command;
  }

  public void click(){
    // receiver.doXMethod();
    command.execute();
  }
}
