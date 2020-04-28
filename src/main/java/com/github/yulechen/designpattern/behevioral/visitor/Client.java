package com.github.yulechen.designpattern.behevioral.visitor;

import com.github.yulechen.designpattern.behevioral.visitor.compiler.VariableRefNode;

/**
 * @Author: chenq
 * @Date: 2020/4/28  15:01
 */
public class Client {

  public static void main(String[] args) {
    VariableRefNode node = new VariableRefNode();
    // old version ,
     node.prettyPrint();
     node.typeCheck();
     node.generateCode();
     // node.XXXX(),会改变所有的类结构，并且重新编译


    // new version
    node.accept(new PrettyPrintVisitor());
    node.accept(new TypeCheckVisitor());
    node.accept(new CodeGeneratingVisitor());

    // 扩展
    // node.accept(new XXXXX());

    // 稳定点，
    // 1、数据结构稳定，NodeVisitor 里面接口就不会变化
    // 2、Node 里面accept 方法稳定，不会变化

    // 变化点
    // 1、新增访问方法， --实现一个NodeVisitor
    // 2、node 新增一个accept（Visitor）

    // 灵活性
    // 1、不会修改稳定的地方 2、扩展性好，灵活性高
  }
}
