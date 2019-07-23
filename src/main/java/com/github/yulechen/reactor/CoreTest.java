package com.github.yulechen.reactor;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;

/**
 * @Author: chenq
 * @Date: 2019/7/23  下午3:33
 */
public class CoreTest {


  public static void main(String[] args) {
    // config produce
    Flux<Integer> ints = Flux.range(1, 10).filter(t->t%2==0);

    // run consumer
    ints.subscribe(new Subscriber() {
      @Override
      public void onSubscribe(Subscription s) {
        System.out.println(System.currentTimeMillis()+" :"+Thread.currentThread().getId() + " :" + s + " onSubscribe ");

      }

      @Override
      public void onNext(Object o) {
        System.out.println(System.currentTimeMillis()+" :"+Thread.currentThread().getId() + " :" + o + " onNext ");
      }

      @Override
      public void onError(Throwable t) {
        System.out.println(System.currentTimeMillis()+" :"+Thread.currentThread().getId() + " :" + t + " onError ");
      }

      @Override
      public void onComplete() {
        System.out.println(System.currentTimeMillis()+" :"+Thread.currentThread().getId() + " :"  + " onComplete ");
      }
    });
     print("main-thread");
    ints.subscribe(CoreTest::print);
    ints.subscribe(CoreTest::print);
  }


  public static void print(Object o){
    System.out.println("time :"+System.currentTimeMillis()+" thread:"+Thread.currentThread().getId() + " data:" + o );
  }
}
