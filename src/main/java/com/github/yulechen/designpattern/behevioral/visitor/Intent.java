package com.github.yulechen.designpattern.behevioral.visitor;

/**
 * @Author: chenq
 * @Date: 2020/4/28  14:46
 */
public class Intent {
/**
 * visitor ：抽象为对一个对象的操作。因为对象上面的操作会频繁发生变化，比如在对象上面添加操作。
 *         ： Visitor ，可以在对象上面添加一个操作，而不破坏现有的数据结构，也不破坏现有的类结构关系
 *
 *
 *应用：
 * 1、the classes defining the object structure rarely change, but you oftenwant to define new operations over the structure
 * 2、you want to perform operations on these objects that depend on their concrete classes
 */

   //trade-off
  // Adding new ConcreteElement classes is hard
  // Breaking encapsulation

  // 迭代器 访问数据，迭代器只能访问指定类型的类，不能访问复杂继承关系的数据结构
}
