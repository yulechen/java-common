package com.github.yulechen.grammar.jdk8.functions;


/**
 *
 * 定义输入输出，函数本身自己实现
 *
 *
 * @param <T>
 */
@FunctionalInterface
public interface GetObjectFunction<T> {

    T createInstance();
}
