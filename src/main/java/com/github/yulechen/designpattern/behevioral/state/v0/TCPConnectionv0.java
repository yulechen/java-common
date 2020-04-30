package com.github.yulechen.designpattern.behevioral.state.v0;

/**
 * @Author: chenq
 * @Date: 2020/4/30  14:35
 */
public class TCPConnectionv0 {

  private String STATE_ESTABLISHED,STATE_Closed,STATE_LISTEN;
  private String currentSate ;



  void open() {
    if(currentSate== STATE_ESTABLISHED){
      System.out.println("open");
    } else  if(currentSate== STATE_Closed){
      System.out.println("open");
    }else  if(currentSate== STATE_LISTEN){
      System.out.println("open");
      System.out.println("change to state STATE_ESTABLISHED");
    }

    System.out.println("doNotiong");
  }

  void close() {
    if(currentSate== STATE_Closed){
      System.out.println("close");
    }
    System.out.println("doNotiong");
  }

  void acknowledge() {
    if(currentSate== STATE_LISTEN){
      System.out.println("ack..");
    }
    System.out.println("doNotiong");
  }


}
