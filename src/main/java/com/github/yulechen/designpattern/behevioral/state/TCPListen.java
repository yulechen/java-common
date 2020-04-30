package com.github.yulechen.designpattern.behevioral.state;

/**
 * @Author: chenq
 * @Date: 2020/4/30  14:38
 */
public class TCPListen implements TCPState {

  TCPState current;

  @Override
  public void open() {
    // if xxx ,doSomething
      // state to established
  }

  @Override
  public void close() {
// if xxx ,doSomething
  }

  @Override
  public void acknowledge() {
// if xxx ,doSomething
  }
}
