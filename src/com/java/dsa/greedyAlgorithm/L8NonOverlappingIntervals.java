package com.java.dsa.greedyAlgorithm;

import java.util.Arrays;

public class L8NonOverlappingIntervals {

    public int eraseOverlapIntervals(int[][] intervals) {

        Arrays.sort(intervals, (a, b) ->
                Integer.compare(a[1], b[1])
        );

        int count = 0;
        int high = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < high) {
                count++;
            } else {
                high = intervals[i][1];
            }
        }

        return count;
    }

    static int selfTry(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });

        int high = intervals[0][1];
        int count = 0;

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < high) {
                count++;
                high = Math.min(high, intervals[i][1]);
            } else
                high = intervals[i][1];
        }

        return count;
    }

    public static void main(String[] args) {
        int[][] intervals = {
                {1, 2},
                {2, 3},
                {3, 4},
                {1, 3}
        };

        System.out.println(selfTry(intervals));
    }
}
