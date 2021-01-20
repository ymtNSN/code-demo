package com.example.demo.algorithm;

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


}
