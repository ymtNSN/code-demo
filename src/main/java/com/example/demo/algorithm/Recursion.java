package com.example.demo.algorithm;

public class Recursion {

    /**
     * 递归反转单向链表
     *
     * @param head
     * @return
     */
    private Node reverse(Node head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        Node last = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    Node successor = null;

    /**
     * 递归反转单向链表前n个节点
     */
    private Node reverse(Node head, int n) {
        if (n == 1) {
            successor = head.next;
            return head;
        }
        Node last = reverse(head.next, n - 1);
        head.next.next = head;
        head.next = successor;
        return last;
    }

    /**
     * 递归反转单向链表第m-n个节点
     */
    private Node reverse(Node head, int m, int n) {
        if (m == 1) {
            return reverse(head, n);
        }
        head.next = reverse(head.next, m - 1, n - 1);
        return head;
    }

    // 反转 a 到 null 之间的结点
    private Node DiDaiReverse(Node head) {
        Node pre = null, cur = head, next = head;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    // 反转 a 到 b 之间的结点
    private Node DiDaiReverse(Node a, Node b) {
        Node pre = null, cur = a, next = a;
        while (cur != b) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    // k 个一组反转链表
    private Node reverseKGroup(Node head, int k) {
        if (head == null) {
            return null;
        }
        Node a = head, b = head;
        for (int i = 0; i < k; i++) {
            if (b == null) {
                return head;
            }
            b = b.next;
        }
        Node newNode = DiDaiReverse(a, b);
        a.next = reverseKGroup(b, k);
        return newNode;
    }


    // 左侧指针
    Node left = null;

    //判断回文单链表
    private boolean isPalindrome(Node head) {
        left = head;
        return traverse(head);
    }

    private boolean traverse(Node right) {
        if (right == null) {
            return true;
        }
        boolean res = traverse(right.next);
        res = res && (right.val == left.val);
        left = left.next;
        return res;
    }


    class Node {
        private int val;
        private Node next;

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }
}
