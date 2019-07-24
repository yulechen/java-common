package com.github.yulechen.reactor.impl;

import org.reactivestreams.Subscription;
import reactor.core.CoreSubscriber;

/**
 * @Author: chenq
 * @Date: 2019/7/24  下午2:43
 */
public class MySubscriber implements CoreSubscriber {


  @Override
  public void onSubscribe(Subscription s) {
    System.out.println("onSubscribe will call Subscription#request method, request method will call onNext");
    // back presure.
    s.request(Integer.MAX_VALUE);
  }

  @Override
  public void onNext(Object o) {
    System.out.println(o);
  }

  @Override
  public void onError(Throwable t) {
    System.out.println("ERROR:"+t);
  }

  @Override
  public void onComplete() {
    System.out.println("onComplete");
  }

}
