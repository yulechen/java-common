package com.github.yulechen.reactor.impl;

import reactor.core.publisher.Mono;

/**
 * @Author: chenq
 * @Date: 2019/7/24  下午3:02
 */
public class Main {

  public static void main(String[] args) {
    MyMono myMono = new MyMono("this is a template.");
    Mono<String> from = Mono.from(myMono);
    from.subscribe(new MySubscriber());
  }

}
