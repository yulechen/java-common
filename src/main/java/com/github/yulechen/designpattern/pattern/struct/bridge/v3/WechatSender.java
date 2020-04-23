package com.github.yulechen.designpattern.pattern.struct.bridge.v3;

import java.util.List;

/**
 * @Author: chenq
 * @Date: 2020/4/23  17:48
 */
public class WechatSender implements MsgSender {
  private List<String> openIds;

  @Override
  public void sendMsg(String message) {
    System.out.println("send wechat message ...");
  }
}
