package com.github.yulechen.grammar.jdk8.stream;

import static java.math.BigInteger.ONE;
import static org.bouncycastle.math.ec.ECConstants.TWO;

import java.math.BigInteger;
import java.util.stream.Stream;

public class ParallelTest {


  public static void main(String[] args) {
    primes().map(p -> TWO.pow(p.intValueExact()).subtract(ONE))
        .filter(mersenne -> mersenne.isProbablePrime(50))
        .limit(20)
        .forEach(System.out::println);
  }
  static Stream<BigInteger> primes() {
    return Stream.iterate(TWO, BigInteger::nextProbablePrime);
  }

}
