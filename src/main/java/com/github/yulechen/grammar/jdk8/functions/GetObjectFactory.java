package com.github.yulechen.grammar.jdk8.functions;

public class GetObjectFactory<T> {

    public  T getObject(GetObjectFunction<T> function){
        return function.createInstance();
    }


    public static void main(String[] args) {
        GetObjectFactory factory =new GetObjectFactory();
        System.out.println(factory.getObject(String::new));
    }
}
