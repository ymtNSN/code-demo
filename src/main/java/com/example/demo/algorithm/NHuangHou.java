package com.example.demo.algorithm;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by @author ymtNSN on 2021/1/29
 */
public class NHuangHou {

    private static List<List<String>> res = new ArrayList<>();

    public static void main(String[] args) {

        List<List<String>> lists = solveNQueens(4);
        System.out.println(lists);
    }

    private static List<List<String>> solveNQueens(int n) {
        int[] result = new int[n];
        calnQueens(0, n, result);
        return res;
    }

    private static void calnQueens(int row, int n, int[] result) {
        if (row == n) {
            getPrint(result);
            System.out.println("------------");

            return;
        }
        for (int column = 0; column < n; column++) {
            if (isOk(row, column, result)) {
                result[row] = column;
                calnQueens(row + 1, n, result);
            }
        }
    }

    private static boolean isOk(int row, int column, int[] result) {
        for (int i = 0; i < row; i++) {
            if (result[i] == column || Math.abs(column - result[i]) == Math.abs(row - i)) {
                return false;
            }
        }
        return true;
    }

    private static void getPrint(int[] result) {
        List<String> one = new ArrayList<>();
        for (int row = 0; row < result.length; row++) {
            // 一行一个StringBuilder
            StringBuilder str = new StringBuilder();
            for (int column = 0; column < result.length; column++) {
                if (column == result[row]) {
                    str.append("Q");
                } else {
                    str.append(".");
                }
            }
            System.out.println(str.toString());
            one.add(str.toString());
        }
        res.add(one);
    }

    void calnQueens2(int row, int n, int[] result) {
        if (row == n) {
            getPrint(result);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (isOk(row, i, result)) {
                result[row] = i;
                calnQueens2(row + 1, n, result);
            }
        }

    }

}
