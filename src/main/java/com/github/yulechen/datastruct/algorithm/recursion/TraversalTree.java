package com.github.yulechen.datastruct.algorithm.recursion;

import java.util.ArrayList;

/**
 * @Author: chenq
 * @Date: 2020/6/2  09:33 求值过程在归的部分
 */
public class TraversalTree {


  public static void main(String[] args) {
    TreeNode tree = createTree();
    ArrayList<Integer> preOrders = new ArrayList<>();
    preOrderTraversal(tree, preOrders);
    System.out.println("前序遍历:"+preOrders);


    ArrayList<Integer> inOrders = new ArrayList<>();
    inOrderTraversal(tree, inOrders);
    System.out.println("中序遍历:"+inOrders);
   // postOrderTraversal(tree, orders);

    ArrayList<Integer> postOrders = new ArrayList<>();
    postOrderTraversal(tree, postOrders);
    System.out.println("后续遍历:"+postOrders);


  }

  /**
   * 前序遍历，根结点 第一个 前序遍历：根结点 ---> 左子树 ---> 右子树
   * 在递的阶段处理
   *
   */
  static void preOrderTraversal(TreeNode root, ArrayList<Integer> nodeCollect) {
    // 终止条件 ,左右子节点都为空。
    if (root.left == null && root.right == null) {
        nodeCollect.add(root.val);
        return;
    }

    // 分的时候添加每个节点的值
    nodeCollect.add(root.val);

    if(root.left!=null){
      preOrderTraversal(root.left, nodeCollect);

    }

    if(root.right!=null){
      preOrderTraversal(root.right, nodeCollect);
    }

  }


  /**
   * 中序遍历，根结点 在中间 中序遍历：左子树---> 根结点 ---> 右子树
   * 在第一部分归中处理。
   */
  static void inOrderTraversal(TreeNode root, ArrayList<Integer> nodeCollect) {
    // 终止条件一样 ,左右子节点都为空。
    if (root.left == null && root.right == null) {
      nodeCollect.add(root.val);
      return;
    }
    if(root.left!=null){
      inOrderTraversal(root.left, nodeCollect);
    }
    nodeCollect.add(root.val);
    if(root.right!=null){
      inOrderTraversal(root.right, nodeCollect);
    }


  }


  /**
   * 后续遍历，根结点最后 后序遍历：左子树 ---> 右子树 ---> 根结点
   * 在所有归完成后处理。
   */
  static void postOrderTraversal(TreeNode root, ArrayList<Integer> nodeCollect) {
    // 终止条件一样 ,左右子节点都为空。
    if (root.left == null && root.right == null) {
      nodeCollect.add(root.val);
      return;
    }
    if(root.left!=null){
      postOrderTraversal(root.left, nodeCollect);
    }

    if(root.right!=null){
      postOrderTraversal(root.right, nodeCollect);
    }
     nodeCollect.add(root.val);
  }


  /**
   * 层次遍历-- 不在这次讨论范围内。
   *
   */
  static void levelOrderTraversal(TreeNode root) {

  }


  /**
   *
   *
   * @return
   */
  public static TreeNode createTree() {
    TreeNode node0 = new TreeNode(0);
    TreeNode node1 = new TreeNode(1);
    TreeNode node2 = new TreeNode(2);
    TreeNode node3 = new TreeNode(3);
    TreeNode node4 = new TreeNode(4);
    TreeNode node5 = new TreeNode(5);
    TreeNode node6 = new TreeNode(6);
    TreeNode node7 = new TreeNode(7);

    node0.left = node1;
    node0.right = node2;

    node1.left= node3;
    node1.right=node4;

    node2.left=node5;
    node2.right=node6;

    node4.left= node7;

    return node0;
  }


  static class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }
}
