package com.example.demo.algorithm;

import java.util.*;

/**
 * Created by @author ymtNSN on 2021/1/29
 */
public class BackTracking {

    private static List<List<Integer>> res = new LinkedList<>();

    public static void main(String[] args) {
//        int[] nums = {1, 2, 3, 4};
//        bt(nums, new LinkedList<Integer>());
//        System.out.println(res);


        LinkedList<Integer> nums = new LinkedList<>();
        nums.add(1);
        nums.add(2);
        nums.add(3);

//        LinkedList<LinkedList<Integer>> subsets = subsets(nums);
//        subsets2(nums, 0, new LinkedList<>());
//        System.out.println(res2);
//        subsets3(4, 2, 1, new LinkedList<>());
//        System.out.println(res3);
//        permute(new int[]{1, 2, 3}, new LinkedList<>());
//        System.out.println(res4);
        generateParenthesis(3,3, new LinkedList<>());
        System.out.println(res5);

    }

    private static void bt(int[] nums, LinkedList<Integer> track) {
        if (track.size() == nums.length) {
            res.add(new LinkedList<>(track));
            return;
        }
        for (int num : nums) {
            if (track.contains(num)) {
                continue;
            }
            track.add(num);
            bt(nums, track);
            track.removeLast();
        }
    }

    void bt2(int[] nums, LinkedList<Integer> track) {
        if (track.size() == nums.length) {
            res.add(new LinkedList<>(track));
            return;
        }
        for (int num : nums) {
            if (track.contains(num)) {
                continue;
            }
            track.add(num);
            bt2(nums, track);
            track.removeLast();
        }
    }

    // 求子集
    static LinkedList<LinkedList<Integer>> subsets(LinkedList<Integer> nums) {
        if (nums.isEmpty()) {
            LinkedList<LinkedList<Integer>> objects = new LinkedList<>();
            objects.add(new LinkedList<Integer>());
            return objects;
        }
        Integer last = nums.removeLast();
        LinkedList<LinkedList<Integer>> res = subsets(nums);
        int size = res.size();
        for (int i = 0; i < size; i++) {
            res.push(res.get(i));
            LinkedList<Integer> list = new LinkedList<>(res.get(i));
            list.add(last);
            res.push(list);
        }
        return res;
    }

    static LinkedList<LinkedList<Integer>> res2 = new LinkedList();

    static void subsets2(LinkedList<Integer> nums, int start, LinkedList<Integer> track) {
        res2.addLast(new LinkedList<>(track));
        for (int i = start; i < nums.size(); i++) {
            track.addLast(nums.get(i));
            subsets2(nums, i + 1, track);
            track.pollLast();
        }
    }

    static LinkedList<LinkedList<Integer>> res3 = new LinkedList();

    // 输入两个数字 n, k，算法输出 [1..n] 中 k 个数字的所有组合。
    static void subsets3(int n, int k, int start, LinkedList<Integer> track) {
        if (track.size() == k) {
            res3.addLast(new LinkedList<>(track));
            return;
        }
        for (int i = start; i <= n; i++) {
            track.addLast(i);
            subsets3(n, k, i + 1, track);
            track.pollLast();
        }
    }

    static LinkedList<LinkedList<Integer>> res4 = new LinkedList<>();

    // 输入一个不包含重复数字的数组 nums，返回这些数字的全部排列。
    static void permute(int[] nums, LinkedList<Integer> track) {
        if (track.size() == nums.length) {
            res4.addLast(new LinkedList<>(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (track.contains(nums[i])) {
                continue;
            }
            track.addLast(nums[i]);
            permute(nums, track);
            track.pollLast();
        }
    }

    // 解数独
    static boolean solveSudoku(char[][] board, int r, int c) {
        int m = 9, n = 9;
        if (c == n) {
            return solveSudoku(board, r + 1, 0);
        }
        if (r == m) {
            return true;
        }
        for (int i = r; i < m; i++) {
            for (int j = c; j < n; j++) {
                if (board[i][j] != '.') {
                    return solveSudoku(board, i, j + 1);
                }
                for (char k = '1'; k < '9'; k++) {
                    if (!isValid(board, i, j, k)) {
                        continue;
                    }
                    board[i][j] = k;
                    solveSudoku(board, i, j + 1);
                    board[i][j] = '.';
                }
            }
            return false;
        }
        return false;
    }

    private static boolean isValid(char[][] board, int r, int c, char k) {
        for (int l = 0; l < 9; l++) {
            if (board[r][l] == k) {
                return false;
            }
            if (board[l][c] == k) {
                return false;
            }
            if (board[(r / 3) * 3 + l / 3][(c / 3) * 3 + l % 3] == k) {
                return false;
            }
        }
        return true;
    }

    // 输入是一个正整数n，输出是n对儿括号的所有合法组合
    static LinkedList<LinkedList<String>> res5 = new LinkedList<>();

    static void generateParenthesis(int left, int right, LinkedList<String> track) {
        if (right < left) {
            return;
        }
        if (left < 0 || right < 0) {
            return;
        }
        if (left == 0 && right == 0) {
            res5.addLast(new LinkedList<>(track));
            return;
        }
        track.addLast("(");
        generateParenthesis(left - 1, right, track);
        track.pollLast();

        track.addLast(")");
        generateParenthesis(left, right - 1, track);
        track.pollLast();
    }
}
