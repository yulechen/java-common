package com.github.yulechen.reactor.customesubscriber;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;

/**
 * @Author: chenq
 * @Date: 2020/4/30  17:52
 */
public class SimpleSubscriber implements Subscriber<Integer> {

  /**
   *
   *
   *
   * onSubscribe -->
   * actual.onSubscribe(new RangeSubscription(actual, start, end));
   * -->FluxRange.request
   * --> for [actual.next,onError]
   *
   *
   * @param args
   */

  private Subscription subscription;

  public static void main(String[] args) {
    Flux.range(1,20).subscribe(new SimpleSubscriber());
  }

  @Override
  public void onSubscribe(Subscription s) {
      subscription=s;
      System.out.println( "onSubscribe Subscription:" +s);
      // for (int i =0 i< n; onNext())
      s.request(10);

  }

  @Override
  public void onNext(Integer integer) {
    if(integer==2){
      subscription.cancel();
    }
    System.out.println( "next:" +integer);
  }

  @Override
  public void onError(Throwable t) {
    System.out.println( "error");
  }

  @Override
  public void onComplete() {
    System.out.println( "conComplate");
  }
}
