package com.github.yulechen.designpattern.pattern.struct.bridge.v1;

import com.github.yulechen.designpattern.pattern.struct.bridge.v3.AllNotify;
import com.github.yulechen.designpattern.pattern.struct.bridge.v3.CompositeSender;
import com.github.yulechen.designpattern.pattern.struct.bridge.v3.EmailSender;
import com.github.yulechen.designpattern.pattern.struct.bridge.v3.MsgSender;
import com.github.yulechen.designpattern.pattern.struct.bridge.v3.SmSSender;
import java.util.Arrays;

/**
 * @Author: chenq
 * @Date: 2020/4/23  17:43
 */
public class Client {

  public static void main(String[] args) {
    // v1
//      Notification notification =new WechatNotify();
//      notification.notify("hello wechat");

      // v3
    MsgSender smsSender = new SmSSender();
    MsgSender emailSender = new EmailSender();


    CompositeSender compositeSender = new CompositeSender(Arrays.asList(smsSender,emailSender));

    Notification nv3= new AllNotify(compositeSender);

    nv3.notify("hello");

  }


}
