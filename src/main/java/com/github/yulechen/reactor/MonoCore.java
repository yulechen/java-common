package com.github.yulechen.reactor;

import reactor.core.publisher.Hooks;
import reactor.core.publisher.Mono;

/**
 * @Author: chenq
 * @Date: 2019/7/23  下午4:40
 */
public class MonoCore {


  /**
   **在相同的线程内执行
   **
   Mono
   - just (data)
      -- MonoJust ( t data)
            - return MonoJust

   - Mono#subscribe (consumer())
      -- LambdaMonoSubscriber(consumer,null,null)#onNext(),consumer.accept(x);
        - subscribe(LambdaMonoSubscriber)
          - subClass#MonoJust#subscribe
              -LambdaMonoSubscriber#onSubscribe(,Data)  生产 ScalarSubscription 生产数据，处理数据，数据关联
                  -LambdaMonoSubscriber#onSubscribe(Subscription)
                      -ScalarSubscription#request （validate（n））
                            -LambdaMonoSubscriber#next
   * @param args
   */
  public static void main(String[] args) {
    Hooks.onEachOperator(t->{
      System.out.println("each"+t);
      return t;
    });
    Mono<String> just = Mono.just("1");
    just.subscribe(System.out::println);
    System.out.println("hello");
  }
}
