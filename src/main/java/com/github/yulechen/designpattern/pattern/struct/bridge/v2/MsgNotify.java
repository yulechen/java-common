package com.github.yulechen.designpattern.pattern.struct.bridge.v2;

import com.github.yulechen.designpattern.pattern.struct.bridge.v1.Notification;

/**
 * @Author: chenq
 * @Date: 2020/4/23  17:44
 */
public class MsgNotify extends Notification {


  // what should to do ........er ........
  @Override
  public void notify(String message) {
    System.out.println("wechat notify");
    System.out.println("Email notify");
    System.out.println("SmS notify");
  }

}
