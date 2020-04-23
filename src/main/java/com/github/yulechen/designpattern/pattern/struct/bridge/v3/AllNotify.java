package com.github.yulechen.designpattern.pattern.struct.bridge.v3;

/**
 * @Author: chenq
 * @Date: 2020/4/23  17:56
 */
public class AllNotify extends AbstractNotification {

  public AllNotify(
      MsgSender msgSender) {
    super(msgSender);
  }

  @Override
  String dealWithMessage(String message) {
    return "SMS:EMAIL:WECHAT"+message;
  }

}
