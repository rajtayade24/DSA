package com.java.dsa.array;

import java.util.*;

public class L23MergeOverlappingIntervals {

    // Optimal Solution
    // Time Complexity : O(n log n)
    // Space Complexity: O(n)
    static int[][] optimalSol(int[][] intervals) {

        // Sort according to starting time
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        List<int[]> ans = new ArrayList<>();
        for (int[] interval : intervals) {
            // No overlap
            if (ans.isEmpty() || interval[0] > ans.getLast()[1]) {
                ans.add(new int[]{interval[0], interval[1]});
            }
            // Overlap
            else {
                ans.getLast()[1] = Math.max(ans.getLast()[1], interval[1]);
            }
        }

        return ans.toArray(new int[ans.size()][]);
    }

    // Brute Force
    // Time Complexity : O(n²)
    // Space Complexity: O(n)
    static int[][] bruteSol(int[][] intervals) {

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        List<int[]> ans = new ArrayList<>();

        int n = intervals.length;

        for (int i = 0; i < n; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];

            // Skip already merged intervals
            if (!ans.isEmpty() && start <= ans.getLast()[1]) {
                continue;
            }

            for (int j = i + 1; j < n; j++) {
                if (intervals[j][0] <= end) {
                    end = Math.max(end, intervals[j][1]);
                } else {
                    break;
                }
            }

            ans.add(new int[]{start, end});
        }

        return ans.toArray(new int[ans.size()][]);
    }

    // Print Matrix
    static void print(int[][] intervals) {
        for (int[] interval : intervals) {
            System.out.println(Arrays.toString(interval));
        }
    }

    public static void main(String[] args) {
        int[][] intervals = {
                {1, 3},
                {4, 8},
                {2, 6},
                {8, 11},
                {8, 10},
                {2, 4},
                {15, 18},
                {16, 17}
        };

        System.out.println("Original Intervals:");
        print(intervals);

        System.out.println("\nMerged Intervals (Optimal):");
        int[][] ans = optimalSol(intervals);
        print(ans);
    }
}