package com.github.yulechen.grammar.jdk8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class CollectionNewApis {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("1", "2", "3", "4,5", "6,7");
        Stream<String> stream = strings.stream();
        stream.map(one->{

            return  one+"aaaa,";
        }).
        flatMap(line -> Stream.of(line.split(","))).forEach(System.out::println);

    }
}
