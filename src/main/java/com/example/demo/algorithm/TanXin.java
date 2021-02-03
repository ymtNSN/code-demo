package com.example.demo.algorithm;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by @author ymtNSN on 2021/2/3
 */
public class TanXin {

    public static void main(String[] args) {
        int[][] points ={{-2147483646,-2147483645},{2147483646,2147483647}};
//        int[][] points ={{10,16},{2,8},{1,6},{7,12}};
        int minArrowShots = findMinArrowShots(points);
        System.out.println(minArrowShots);
        System.out.println(2147483647 - (-2147483645));
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
    }

    public static int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] > 0 && o2[1] < 0) {
                    return 1;
                }
                if (o1[1] < 0 && o2[1] > 0) {
                    return -1;
                }
                return o1[1] - o2[1];
            }
        });
        int count = 1;
        int maxEnd = points[0][1];
        for (int[] point : points) {
            if (point[0] > maxEnd) {
                count++;
                maxEnd = point[1];
            }
        }
        return count;
    }
}
