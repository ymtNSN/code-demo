package com.example.demo.algorithm;

import org.apache.commons.lang.text.StrBuilder;

import java.util.*;

/**
 * Created by @author ymtNSN on 2021/2/3
 */
public class Bfs {

    public static void main(String[] args) {
        String[] deads = {"8888"};
        int res = openLock(deads, "0009");
        System.out.println(res);
    }

    public static int openLock(String[] deadends, String target) {
        Set<String> deads = new HashSet<>();
        for (String dead : deadends) {
            deads.add(dead);
        }
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        int step = 0;
        queue.offer("0000");
        visited.add("0000");
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                if (cur.equals(target)) {
                    return step;
                }
                if (deads.contains(cur)) {
                    continue;
                }
                for (int j = 0; j < 4; j++) {
                    String up = plusOne(cur, j);
                    if (!visited.contains(up)) {
                        queue.offer(up);
                        visited.add(up);
                    }
                    String down = minusOne(cur, j);
                    if (!visited.contains(down)) {
                        queue.offer(down);
                        visited.add(down);
                    }
                }
            }
            step++;
        }
        return -1;
    }

    private static String plusOne(String s, int j) {
        char[] ch = s.toCharArray();
        if (ch[j] == '9') {
            ch[j] = '0';
        } else {
            ch[j] += 1;
        }
        return new String(ch);
    }

    private static String minusOne(String s, int j) {
        char[] ch = s.toCharArray();
        if (ch[j] == '0') {
            ch[j] = '9';
        } else {
            ch[j] -= 1;
        }
        return new String(ch);
    }


    // 滑动拼图
    static int slidingPuzzle(int[][] board) {

        int[][] neighbor = {
                {1, 3},
                {0, 4, 2},
                {1, 5},
                {0, 4},
                {3, 1, 5},
                {4, 2}
        };
        int m = 2, n = 3;
        String start = "";
        String target = "123450";
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                start += board[i][j] + '0';
            }
        }
        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        Set<String> visited = new HashSet<>();
        visited.add(start);

        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                if (cur.equals(target)) {
                    return step;
                }
                // 找到目前‘0’的索引
                int idx = 0;
                for (; cur.charAt(idx) != '0'; idx++) {
                    ;
                }
                // 将‘0’相邻数字交换
                for (int adj : neighbor[idx]) {
                    StrBuilder sb = new StrBuilder(cur);
                    sb.setCharAt(idx, cur.charAt(adj));
                    sb.setCharAt(adj, cur.charAt(idx));
                    String newBoard = sb.toString();
                    if (!visited.contains(newBoard)) {
                        queue.add(newBoard);
                        visited.add(newBoard);
                    }
                }
            }
            step++;
        }
        return -1;
    }

}
