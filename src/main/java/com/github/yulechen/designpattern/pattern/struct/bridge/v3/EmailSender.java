package com.github.yulechen.designpattern.pattern.struct.bridge.v3;

import java.util.List;

/**
 * @Author: chenq
 * @Date: 2020/4/23  17:48
 */
public class EmailSender implements MsgSender {

  private List<String> emails;

  @Override
  public void sendMsg(String message) {
    System.out.println("send email message ..."+message);
  }

}
