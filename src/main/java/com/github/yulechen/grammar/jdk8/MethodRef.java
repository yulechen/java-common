package com.github.yulechen.grammar.jdk8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class MethodRef {
    /**
     *
     * @FunctionalInterface
     *
     * 最终采取的方法是：增加函数式接口的概念。函数式接口就是一个具有一个方法的普通接口。
     * 像这样的接口，可以被隐式转换为lambda表达式
     *  一个接口里面只有一个方法 ，并且加上@FunctionalInterface 注解，可以Lambda 方法调用。
     * @param args
     */

    public static void main(String[] args) {
        //第一种方法引用是构造器引用，它的语法是Class::new
        final Car car = Car.create( Car::new );
        final List< Car > cars = Arrays.asList( car );
        //第二种方法引用是静态方法引用，它的语法是Class::static_method

        cars.forEach( Car::collide );
    }

    public static class Car {
        public static Car create( final Supplier< Car > supplier ) {
            return supplier.get();
        }

        public static void collide( final Car car ) {
            System.out.println( "Collided " + car.toString() );
        }

        public void follow( final Car another ) {
            System.out.println( "Following the " + another.toString() );
        }

        public void repair() {
            System.out.println( "Repaired " + this.toString() );
        }
    }
}
