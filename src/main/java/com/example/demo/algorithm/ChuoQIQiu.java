package com.example.demo.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by @author ymtNSN on 2021/2/22
 */
public class ChuoQIQiu {


    int res = Integer.MIN_VALUE;

    void bt(List<Integer> nums, int score) {
        if (nums.isEmpty()) {
            res = Math.max(res, score);
            return;
        }
        for (int i = 0; i < nums.size(); i++) {
            int val = nums.get(i);
            int point = nums.get(i - 1) * nums.get(i) * nums.get(i + 1);
            nums.remove(i);
            bt(new ArrayList<>(nums), score + point);
            nums.add(i, val);
        }
    }

    int dp(List<Integer> nums) {
        int n = nums.size();
        nums.add(0, 1);
        nums.add(nums.size() - 1, 1);

        int[][] dp = new int[nums.size()][nums.size()];

        for (int i = n; i >= 0; i--) {
            for (int j = i + 1; j < n + 2; j++) {
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k][j] + nums.get(k) * nums.get(i) * nums.get(j));
                }
            }
        }
        return dp[0][nums.size() - 1];
    }
}
