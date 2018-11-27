package com.github.yulechen.leetcode;

import java.util.ArrayList;
import java.util.List;


public class BinaryTreeMidTraverse {

    /**
     *
     * @param root
     * @return
     */
    private List<Integer> result = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        if (null == root)
            return result;

        result = inorderTraversal(root.left);

        result.add(root.val);

        result = inorderTraversal(root.right);

        return result;
    }


    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> r = new ArrayList<>();
        if (null == root)
            return r;
        r.addAll(inorderTraversal2(root.left));

        r.add(root.val);

        r.addAll(inorderTraversal2(root.right));

        return r;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {

        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node1.right = node2;
        node2.left = node3;
        BinaryTreeMidTraverse bmtr = new BinaryTreeMidTraverse();
        System.out.println(bmtr.inorderTraversal(node1));
        System.out.println(bmtr.inorderTraversal2(node1));


    }


}