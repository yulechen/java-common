package com.github.yulechen.designpattern.behevioral.visitor.compiler;

import com.github.yulechen.designpattern.behevioral.visitor.NodeVisitor;

/**
 * @Author: chenq
 * @Date: 2020/4/28  14:51
 */
public class VariableRefNode extends Node {

  @Override
 public void typeCheck() {

  }

  @Override
  public void generateCode() {

  }

  @Override
 public  void prettyPrint() {

  }

  @Override
  public void accept(NodeVisitor visitor) {
    visitor.visitVariableRefNode(this);
  }
}
