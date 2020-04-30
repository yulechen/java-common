package com.github.yulechen.designpattern.behevioral.state;

/**
 * @Author: chenq
 * @Date: 2020/4/30  14:35
 */
public class TCPConnection {

  private TCPState tcpState;

  void open() {
    tcpState.open();
  }

  void close() {
    tcpState.close();
  }

  void acknowledge() {
    tcpState.acknowledge();
  }

  public void setTcpState(TCPState tcpState) {
    this.tcpState = tcpState;
  }
}
