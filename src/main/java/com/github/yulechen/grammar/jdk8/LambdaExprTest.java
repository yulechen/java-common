package com.github.yulechen.grammar.jdk8;

import java.util.Arrays;
import java.util.List;

/**
 *
 * 以前使用匿名类 ：Java程序员不得不使用毫无新意的匿名类来代替lambda
 * Lambda允许把函数作为一个方法的参数（函数作为参数传递进方法中）
 *  一个lambda可以由用逗号分隔的参数列表、–>符号与函数体三部分表示
 */
public class LambdaExprTest {

    public static void main(String[] args) {

//        Arrays.asList( "a", "b", "d" ).forEach(e -> System.out.println( e ) );
//        Arrays.asList( "a", "b", "d" ).forEach( ( String e ) -> System.out.println( e ) );
//        Arrays.asList( "a", "b", "d" ).forEach( e -> {
//            System.out.print( e );
//            System.out.print( e );
//        } );
        List<String> strings = Arrays.asList("d", "b", "a");
        strings.sort( ( e1, e2 ) -> e1.compareTo( e2 ) );
        System.out.println(strings);
    }
}
