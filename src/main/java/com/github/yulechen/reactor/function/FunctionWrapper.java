package com.github.yulechen.reactor.function;

import java.util.function.Function;
import java.util.function.Supplier;
import org.reactivestreams.Publisher;

/**
 * @Author: chenq
 * @Date: 2020/4/30  17:01
 */
public class FunctionWrapper {

  private Function<Publisher<?>, Publisher<?>> function;
  private Supplier<Publisher<?>> supplier;
  private Publisher<String> argument;

  public Function<Publisher<?>, Publisher<?>> getFunction() {
    return function;
  }

  public Supplier<Publisher<?>> getSupplier() {
    return supplier;
  }

  public Publisher<String> getArgument() {
    return argument;
  }

  public void setArgument(Publisher<String> argument) {
    this.argument = argument;
  }

  public FunctionWrapper(
      Function<? extends Publisher<?>, ? extends Publisher<?>> function,
      Supplier<? extends Publisher<?>> supplier) {
    this.function = (Function<Publisher<?>, Publisher<?>>) function;
    this.supplier = (Supplier<Publisher<?>>) supplier;
  }

  public Function<Publisher<?>, Publisher<?>> function() {
    return function;
  }
}
