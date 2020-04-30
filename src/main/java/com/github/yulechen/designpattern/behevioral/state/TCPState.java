package com.github.yulechen.designpattern.behevioral.state;

/**
 * @Author: chenq
 * @Date: 2020/4/30  14:35
 */
public interface TCPState {

  void open();

  void close();

  void acknowledge();
}
