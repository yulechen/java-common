package com.github.yulechen.designpattern.pattern.struct.bridge.v3;

import java.util.List;

/**
 * @Author: chenq
 * @Date: 2020/4/23  17:57
 */
public class CompositeSender implements  MsgSender {

  private List<MsgSender>  msgSenders;

  public CompositeSender(
      List<MsgSender> msgSenders) {
    this.msgSenders = msgSenders;
  }

  @Override
  public void sendMsg(String message) {
    for (MsgSender msgSender : msgSenders) {
       msgSender.sendMsg(message);
    }
  }

}
