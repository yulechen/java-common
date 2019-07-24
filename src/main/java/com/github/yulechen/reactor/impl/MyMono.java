package com.github.yulechen.reactor.impl;

import reactor.core.CoreSubscriber;
import reactor.core.publisher.Mono;

/**
 * @Author: chenq
 * @Date: 2019/7/24  下午3:00
 */
public class MyMono extends Mono<String>{

  private  final  String value;

  public MyMono(String value) {
    this.value=value;
  }

  /**
   * actual is a MySubscriber
   * @param actual
   */
  @Override
  public void subscribe(CoreSubscriber<? super String> actual) {
    MySubscription mySubscription = new MySubscription(this.value,actual);
    actual.onSubscribe(mySubscription);
  }


}
