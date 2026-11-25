package com.java.dsa.greedyAlgorithm;

import java.util.Arrays;

public class L3FractionalKnapsack {


    static double fractionalKnapsack(int[] val, int[] wt, long cap) {
        int n = val.length;
        double[][] items = new double[n][2];

        for (int i = 0; i < n; i++) {
            items[i][0] = val[i];
            items[i][1] = wt[i];
        }

        Arrays.sort(items, (a, b) -> Double.compare(b[0] / b[1], a[0] / a[1]));

        double ans = 0;
        for (int i = 0; i < n; i++) {
            if (items[i][1] <= cap) {
                ans += items[i][0];
                cap -= (long) items[i][1];
            } else {
                ans += (items[i][0] / items[i][1]) * cap;
                return ans;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] val = {60, 100, 120};
        int[] wt = {10, 20, 30};
        long capacity = 50;

        System.out.println(fractionalKnapsack(val, wt, capacity));
    }
}
