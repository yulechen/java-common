package com.github.yulechen.designpattern.behevioral.state;

/**
 * @Author: chenq
 * @Date: 2020/4/30  14:39
 */
public class Client {

  public static void main(String[] args) {

    TCPConnection connection =new TCPConnection();

    TCPState stateEstablised = new TCPEstablished();
    TCPState stateClosed = new TCPClosed();
    TCPState stateListen = new TCPListen();

    connection.setTcpState(stateListen);
    connection.setTcpState(stateClosed);
    connection.setTcpState(stateEstablised);

    // 稳定，委派给TCPState 处理
    connection.open();
    connection.close();



  }
}
