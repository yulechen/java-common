package com.github.yulechen.reactor;

import java.util.Optional;
import reactor.core.publisher.Mono;

/**
 * Mono 只包含0，1一个元素
 */
public class MonoMain {


  public static void main(String[] args) {
    Mono.fromSupplier(() -> "Hello").subscribe(System.out::println);
    Mono.justOrEmpty(Optional.of("Hello")).subscribe(System.out::println);
    Mono.create(sink -> sink.success("Hello")).subscribe(System.out::println);
  }
}
