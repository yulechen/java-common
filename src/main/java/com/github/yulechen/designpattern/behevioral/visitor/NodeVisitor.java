package com.github.yulechen.designpattern.behevioral.visitor;

import com.github.yulechen.designpattern.behevioral.visitor.compiler.AssignmentNode;
import com.github.yulechen.designpattern.behevioral.visitor.compiler.VariableRefNode;

/**
 * @Author: chenq
 * @Date: 2020/4/28  14:54
 */
public interface NodeVisitor {

   // 定义所有的数据结构的访问者

   // 语法技巧： 参数为Node 还是 Concreat Node
   // 是否能够依据参数自动匹配
   // double-dispatch
   void visitAssignment(AssignmentNode node);
   void visitVariableRefNode(VariableRefNode node);

}
