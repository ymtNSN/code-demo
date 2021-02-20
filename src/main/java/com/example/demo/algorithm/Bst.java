package com.example.demo.algorithm;

import javax.swing.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by @author ymtNSN on 2021/2/5
 */
public class Bst {

    /**
     * 判断 BST 的合法性
     *
     * @param root
     * @return
     */
    private boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }


    private boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) {
            return true;
        }
        if (min != null && root.val <= min.val) {
            return false;
        }
        if (max != null && root.val >= max.val) {
            return false;
        }
        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
    }

    /**
     * 在 BST 中查找⼀个数是否存在
     */
    private boolean isInBst(TreeNode root, int target) {
        if (root == null) {
            return false;
        }
        if (root.val == target) {
            return true;
        }
        if (root.val > target) {
            return isInBst(root.left, target);
        } else {
            return isInBst(root.right, target);
        }
    }

    /**
     * 在 BST 中删除⼀个数
     */
    public TreeNode deleteNode(TreeNode root, int target) {
        if (root == null) {
            return null;
        }
        if (root.val == target) {
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            TreeNode minNode = getMin(root.right);
            root.val = minNode.val;
            root.right = deleteNode(root.right, minNode.val);
        } else if (root.val > target) {
            root.left = deleteNode(root.left, target);
        } else {
            root.right = deleteNode(root.right, target);
        }
        return root;
    }

    private TreeNode getMin(TreeNode node) {
        while (node != null) {
            node = node.left;
        }
        return node;
    }


    class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int val) {
            this(val, null, null);
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    private final AtomicInteger ctl = new AtomicInteger(ctlOf(RUNNING, 0));
    private static final int COUNT_BITS = Integer.SIZE - 3;
    private static final int CAPACITY   = (1 << COUNT_BITS) - 1;

    // runState is stored in the high-order bits
    private static final int RUNNING    = -1 << COUNT_BITS;
    private static final int SHUTDOWN   =  0 << COUNT_BITS;
    private static final int STOP       =  1 << COUNT_BITS;
    private static final int TIDYING    =  2 << COUNT_BITS;
    private static final int TERMINATED =  3 << COUNT_BITS;

    // Packing and unpacking ctl
    private static int runStateOf(int c)     { return c & ~CAPACITY; }
    private static int workerCountOf(int c)  { return c & CAPACITY; }
    private static int ctlOf(int rs, int wc) { return rs | wc; }

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(-1));
        System.out.println(Integer.toBinaryString(COUNT_BITS));
        System.out.println(Integer.toBinaryString(RUNNING));
        System.out.println(Integer.toBinaryString(SHUTDOWN));
        System.out.println(Integer.toBinaryString(STOP));
        System.out.println(Integer.toBinaryString(STOP-1));
        System.out.println(Integer.toBinaryString(TIDYING));
        System.out.println(Integer.toBinaryString(TERMINATED));
    }
}
