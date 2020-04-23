package com.github.yulechen.designpattern.pattern.struct.bridge.v3;

/**
 * @Author: chenq
 * @Date: 2020/4/23  17:55
 */
public class SmsNotifycation extends AbstractNotification {

  public SmsNotifycation(
      MsgSender msgSender) {
    super(msgSender);
  }

  @Override
  String dealWithMessage(String message) {
    return "sms:"+message;
  }

}
