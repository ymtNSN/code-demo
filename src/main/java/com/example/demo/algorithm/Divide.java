package com.example.demo.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 分治
 * Created by @author ymtNSN on 2021/2/22
 */
public class Divide {


    static List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i + 1));
                for (int le : left) {
                    for (int ri : right) {
                        if (c == '+') {
                            res.add(le + ri);
                        } else if (c == '-') {
                            res.add(le - ri);
                        } else if (c == '*') {
                            res.add(le * ri);
                        }
                    }
                }
            }
        }
        if (res.isEmpty()) {
            res.add(Integer.valueOf(input));
        }
        return res;
    }

    public static void main(String[] args) {
        List<Integer> res = diffWaysToCompute("2-1-1");
        System.out.println(res);
    }
}
