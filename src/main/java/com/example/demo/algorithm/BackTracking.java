package com.example.demo.algorithm;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by @author ymtNSN on 2021/1/29
 */
public class BackTracking {

    private static List<List<Integer>> res = new LinkedList<>();

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        bt(nums, new LinkedList<Integer>());
        System.out.println(res);
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
}
