package com.example.demo.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by @author ymtNSN on 2020/10/30
 */
public class DynamicPlanning {

    // weight:物品重量， n:物品个数，w:背包可承载重量
    public int knapsack(int[] weight, int n, int w) {
        boolean[][] states = new boolean[n][w + 1];
        states[0][0] = true;
        states[0][weight[0]] = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < w; j++) {
                if (states[i][j]) {

                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int res = looseChange(coins, 85);
        System.out.println(res);
    }

    /**
     * description: 筹零钱问题
     *
     * @param coins  coins
     * @param amount amount
     * @return {@link int}
     */
    public static int looseChange(int[] coins, int amount) {
        int[] dpArr = new int[amount + 1];
        dpArr[0] = 0;
        for (int i = 1; i < dpArr.length; i++) {
            dpArr[i] = i + 1;
        }
        return dp3(coins, amount, dpArr);
//        return dp2(coins, amount);
    }

    private static int dp(int[] coins, int balance) {
        int res = Integer.MAX_VALUE;
        if (balance == 0) {
            return 0;
        }
        if (balance < 0) {
            return -1;
        }
        for (int coin : coins) {
            int sub = dp(coins, balance - coin);
            if (sub == -1) {
                continue;
            }
            res = Math.min(res, 1 + sub);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private static Map<Integer, Integer> map = new HashMap<>();

    private static int dp2(int[] coins, int balance) {
        if (map.containsKey(balance)) {
            return map.get(balance);
        }
        int res = Integer.MAX_VALUE;
        if (balance == 0) {
            return 0;
        }
        if (balance < 0) {
            return -1;
        }
        for (int coin : coins) {
            int sub = dp2(coins, balance - coin);
            if (sub == -1) {
                continue;
            }
            res = Math.min(res, 1 + sub);
        }
        int rest = res == Integer.MAX_VALUE ? -1 : res;
        map.put(balance, rest);
        return rest;
    }


    private static int dp3(int[] coins, int balance, int[] dpArr) {
        for (int i = 0; i < dpArr.length; i++) {
            for (int coin : coins) {
                if (i - coin < 0) {
                    continue;
                }
                dpArr[i] = Math.min(dpArr[i], 1 + dpArr[i - coin]);
            }
        }
        return dpArr[balance] == balance + 1 ? -1 : dpArr[balance];
    }

}
