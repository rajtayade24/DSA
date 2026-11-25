package com.java.dsa.greedyAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L9InsertInterval {

    static int[][] selfTry(int[][] intervals, int[] newInterval) {
        List<List<Integer>> ansList = new ArrayList<>();

        int index = 0;
        int n = intervals.length;

        // Step 1: Add intervals before newInterval
        while (index < n && intervals[index][1] < newInterval[0]) {
            ansList.add(Arrays.asList(intervals[index][0], intervals[index][1]));
            index++;
        }

        // Step 2: Merge overlapping intervals
        int start = newInterval[0];
        int end = newInterval[1];

        while (index < n && intervals[index][0] <= end) {
            start = Math.min(start, intervals[index][0]);
            end = Math.max(end, intervals[index][1]);
            index++;
        }
        ansList.add(Arrays.asList(start, end));

        // Step 3: Add remaining intervals
        while (index < n) {
            ansList.add(Arrays.asList(intervals[index][0], intervals[index][1]));
            index++;
        }

        // Step 4: Convert List<List<Integer>> to int[][]
        int[][] ans = new int[ansList.size()][2];

        for (int i = 0; i < ansList.size(); i++) {
            for (int j = 0; j < 2; j++) {
                ans[i][j] = ansList.get(i).get(j);
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        int[][] intervals = {
                {1, 2},
                {3, 5},
                {6, 7},
                {8, 10},
                {12, 16}
        };

        int[] newInterval = {4, 8};

        System.out.println(Arrays.deepToString(selfTry(intervals, newInterval)));
    }
}
