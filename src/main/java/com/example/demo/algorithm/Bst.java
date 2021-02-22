package com.example.demo.algorithm;

import sun.plugin.cache.OldCacheEntry;
// 优先级队列是基于二叉堆实现的，主要操作是插入和删除。
// 插入是先插到最后，然后上浮到正确位置；
// 删除是把第一个元素 pq[1]（最值）调换到最后再删除，然后把新的 pq[1] 下沉到正确位置
// 堆
public class BST {

    int count;

    // 父节点索引
    int parent(int root) {
        return root / 2;
    }

    int left(int root) {
        return root * 2;
    }

    int right(int root) {
        return root * 2 + 1;
    }

    // 上浮只需要跟父节点比较就好
    private void swim(int k){
        while (k > 1 && less(parent(k),k)){
            exch(parent(k),k);
            k = parent(k);
        }
    }

    // 下沉需要跟两个节点比较
    private void sink(int k){
        while (left(k) <= count){
            int max = left(k);
            if (right(k) <= count && less(max,right(k))){
                max = right(k);
            }
            if (less(max,k)){
                break;
            }
            exch(k, max);
            k = max;
        }
    }

    private void exch(int parent, int k) {


    }

    private boolean less(int parent, int k) {
        return false;
    }

    class Node {

    }
}
