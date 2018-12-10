package com.github.yulechen.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 后续遍历二叉树
 */
public class TraversalPostOrder {


  public static void main(String[] args) {

    TreeNode node1 = new TreeNode(1);
    TreeNode node2 = new TreeNode(2);
    TreeNode node3 = new TreeNode(3);
    node1.right = node2;
    node2.left = node3;
    TraversalPostOrder bmtr = new TraversalPostOrder();
    System.out.println(bmtr.postorderTraversal(node1));


  }

  public List<Integer> postorderTraversal(TreeNode root) {
    List<Integer> r = new ArrayList<>();
    if (null == root) {
      return r;
    }
    r.addAll(postorderTraversal(root.left));
    r.addAll(postorderTraversal(root.right));
    r.add(root.val);
    return r;
  }


}
