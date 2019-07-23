package com.github.yulechen.reactor;

import reactor.core.publisher.Flux;

/**
 * @Author: chenq
 * @Date: 2019/7/18  下午4:07
 */
public class FirstTest {

  public static void main(String[] args) {
//    // this is just delcare task flow , not do anything util call subscribe
//    Flux<Integer> ints = Flux.range(1, 4)
//        .map(i -> {
//          System.out.println("inter"+i);
//          if (i <= 3) return i;
//          throw new RuntimeException("Got to 4");
//        });
//    // 并行+异步 执行task
//    ints.subscribe(i -> System.out.println(i),
//        error -> System.err.println("Error: " + error));
//
//



// Backpressure :负压 request
    Flux<Integer> ints = Flux.range(1, 11);
    ints.subscribe(i -> System.out.println(i),
        error -> System.err.println("Error " + error),
        () -> System.out.println("Done"),
        sub -> sub.request(10));
  }
}
