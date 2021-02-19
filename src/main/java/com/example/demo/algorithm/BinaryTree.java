package com.example.demo.algorithm;

/**
 * @author admin
 */
public class BinaryTree {

    private void traverse(TreeNode root) {
        // 前序
        traverse(root.left);
        // 中序
        traverse(root.right);
        // 后序
    }

    private int count(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + count(root.left) + count(root.right);
    }


    class TreeNode {

        private int val;
        private TreeNode left;
        private TreeNode right;

    }

    public static void main(String[] args) {
        System.out.println(9.17+9.28+10.25+10.25+11.13+11.13+11.14+11.14+11.27+12.04+12.05+12.22+12.25+12.26+1.03);
    }
}
