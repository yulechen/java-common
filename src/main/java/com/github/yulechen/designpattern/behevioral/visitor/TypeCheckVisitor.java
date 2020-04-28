package com.github.yulechen.designpattern.behevioral.visitor;

import com.github.yulechen.designpattern.behevioral.visitor.compiler.AssignmentNode;
import com.github.yulechen.designpattern.behevioral.visitor.compiler.VariableRefNode;

/**
 * @Author: chenq
 * @Date: 2020/4/28  14:56
 */
public class TypeCheckVisitor implements  NodeVisitor {

  @Override
  public void visitAssignment(AssignmentNode node) {

  }

  @Override
  public void visitVariableRefNode(VariableRefNode node) {

  }
}
