package com.github.yulechen.reactor.function;

import java.util.function.Function;
import reactor.core.publisher.Flux;

/**
 * @Author: chenq
 * @Date: 2020/4/30  17:07
 */
public class Client {

  public static void main(String[] args) {

    Flux.just("a").map(v->v.toUpperCase()).subscribe(System.out::println);


   // Flux<String> a = uppercase().apply(Flux.just("a"));

  }

  public  static Function<Flux<String>, Flux<String>> uppercase() {
    return flux -> flux.map(value -> value.toUpperCase());
  }


}
