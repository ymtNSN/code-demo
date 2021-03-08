package com.example.demo.algorithm;

/**
 * Created by @author ymtNSN on 2021/2/25
 */
public class Sqr {

    static double get(double x) {
        if (x <= 1) {
            return x;
        }

        double left = 0, right = x;
        while (right - left > 0.01) {
            double mid = (left + right) / 2;
            double res = mid * mid;
            if (res == x) {
                return mid;
            } else if (res < x) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (left * left <= x) {
            return Math.floor(left);
        } else {
            return Math.floor(right);
        }
    }

    public static void main(String[] args) {
        System.out.println(get(1));
    }
}
