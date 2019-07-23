package com.github.yulechen.reactor;

import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;
import reactor.core.publisher.Flux;

/**
 * @Author: chenq
 * @Date: 2019/7/18  下午4:15
 */
public class SecondTest {

  public static void main(String[] args) {
//    SampleSubscriber<Integer> ss = new SampleSubscriber<Integer>();
//    Flux<Integer> ints = Flux.range(1, 4);
////    ints.subscribe(i -> System.out.println(i),
////        error -> System.err.println("Error " + error),
////        () -> {System.out.println("Done");},
////        s -> s.request(10));
//    ints.subscribe(ss);


    Flux.range(1, 10)
        .doOnRequest(r -> System.out.println("request of " + r))
        .subscribe(new BaseSubscriber<Integer>() {

          @Override
          public void hookOnSubscribe(Subscription subscription) {
            request(10);
          }

          @Override
          public void hookOnNext(Integer integer) {
            System.out.println("Cancelling after having received " + integer);
            cancel();
           // request(2);
          }
        });
  }


  static class SampleSubscriber<T> extends BaseSubscriber<T> {

    public void hookOnSubscribe(Subscription subscription) {
      System.out.println("Subscribed");
      request(100);
    }

    public void hookOnNext(T value) {
      System.out.println(value);
      request(20);
    }
  }
}
