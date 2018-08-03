package com.github.yulechen.grammar.jdk8.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListDemo {

    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();//Collections.emptyList();
        for(int i =1 ;i<10;i++){
            if(i%3==0){
                stringList.add(""+1+","+"a");
            }else{
                stringList.add(""+i);
            }

        }
        stringList.stream().flatMap(t->{
            if(t.contains(",")){
                return Stream.of(t.split(","));
            }else{
                return Stream.of(t);
            }
        }).peek(a-> {
            System.out.println(a);
        }).collect(Collectors.toList());



    }
}
