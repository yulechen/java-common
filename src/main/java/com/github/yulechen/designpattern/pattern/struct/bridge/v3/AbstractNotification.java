package com.github.yulechen.designpattern.pattern.struct.bridge.v3;

import com.github.yulechen.designpattern.pattern.struct.bridge.v1.Notification;

/**
 * @Author: chenq
 * @ redefine abstract
 * @Date: 2020/4/23  17:50
 */
public abstract  class AbstractNotification extends Notification {

  private MsgSender msgSender;

  public AbstractNotification(
      MsgSender msgSender) {
    this.msgSender = msgSender;
  }

  @Override
  public void notify(String message) {
    String s = dealWithMessage(message);
    msgSender.sendMsg(s);
  }

  abstract String dealWithMessage(String message);

}
