package com.github.yulechen.grammar.jdk8.stream;

import java.util.stream.Stream;

public class Reduce {

  /**
   * Sum, min, max, average, and string concatenation are all specia
   * @param args
   */
  public static void main(String[] args) {
    Stream<Integer> integers = Stream.of(1, 2, 3, 4);

    /**
     *     T result = identity;
     *     for (T element : this stream)
     *         result = accumulator.apply(result, element)
     *     return result;
     */
    System.out.println(integers.reduce(1, Integer::sum));

  }


}
