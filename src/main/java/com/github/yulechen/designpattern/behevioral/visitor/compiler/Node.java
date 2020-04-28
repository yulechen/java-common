package com.github.yulechen.designpattern.behevioral.visitor.compiler;

import com.github.yulechen.designpattern.behevioral.visitor.NodeVisitor;

/**
 * @Author: chenq
 * @Date: 2020/4/28  14:50
 */
public  abstract class Node {

  public abstract void typeCheck();
  public abstract void generateCode();
  public abstract void prettyPrint();

  // if we want add some function ....
  // 所有的类都会改变，并且重新编译
  // 将所有的方法统一一个入口出去
  public abstract void  accept(NodeVisitor visitor);
}
