package com.github.yulechen.designpattern.pattern.struct.bridge.v1;

import java.util.List;

/**
 * @Author: chenq
 * @Date: 2020/4/23  17:40
 */
public class EmailNotify extends Notification {

  private List<String> email;

  @Override
  public void notify(String message) {
      System.out.println("do notify and deal with Email message ");
      sendMsg(message);
  }

  private void sendMsg(String message){
    System.out.println("wechat service send message"+email);
  }

}
