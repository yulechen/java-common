package com.github.yulechen.reactor.function;

import java.util.function.Function;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Mono;

/**
 * @Author: chenq
 * @Date: 2020/4/30  17:03
 */
public class RequesProcessor {

  public Mono<ResponseEntity<?>> get(FunctionWrapper wrapper) {
    if (wrapper.function() != null) {
      return response(wrapper, wrapper.function(), value(wrapper), true, true);
    }
    return Mono.empty();
  }

  private Mono<ResponseEntity<?>> response(FunctionWrapper wrapper,
      Function<Publisher<?>, Publisher<?>> function, Object value, boolean b, boolean b1) {
    return null;
  }

  private Object value(FunctionWrapper wrapper) {
    return null;
  }
}
