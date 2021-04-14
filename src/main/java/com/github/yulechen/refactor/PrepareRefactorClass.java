package com.github.yulechen.refactor;

// rename shift+f6
public class PrepareRefactorClass {


  public String hello(String name){
    return "hello" +name;
  }


  // extract var  common code
  static String getUsernameFromMessage(String message) {
    return message.substring(message.indexOf("\"screen_name\":\"") + 15,
        message.indexOf("\"", message.indexOf("\"screen_name\":\"") + 15));
  }
}
