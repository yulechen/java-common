package com.github.yulechen.reactor.impl;

import org.reactivestreams.Subscription;
import reactor.core.CoreSubscriber;

/**
 * @Author: chenq
 * @Date: 2019/7/24  下午3:00
 */
public class MySubscription implements Subscription {

  private String data;

  private CoreSubscriber<? super String> actual;

  public MySubscription(String data,CoreSubscriber actual) {
    this.data = data;
    this.actual =actual;
  }

  @Override
  public void request(long n) {
    for(int i= 0; i<10 ;i++){
      actual.onNext(data);
    }
    actual.onComplete();
    actual.onError(new RuntimeException("MOCK ERROR."));
  }

  @Override
  public void cancel() {

  }


}
