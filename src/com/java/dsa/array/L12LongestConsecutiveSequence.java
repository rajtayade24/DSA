package com.java.dsa.array;

import java.util.Arrays;
import java.util.HashSet;

public class L12LongestConsecutiveSequence {

    // Optimal Solution - HashSet - O(n)
    static int optimalSol(int[] nums) {

        int n = nums.length;
        if (n == 0) return 0;

        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int longest = 1;
        for (int num : set) {
            // Start of a sequence
            if (!set.contains(num - 1)) {
                int current = num;
                int count = 1;
                while (set.contains(current + 1)) {
                    current++;
                    count++;
                }
                longest = Math.max(longest, count);
            }
        }

        return longest;
    }

    // Better Solution - Sorting - O(n log n)
    static int betterSol(int[] nums) {
        if (nums.length == 0) return 0;

        Arrays.sort(nums);

        int count = 1, longest = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1])
                continue; // Ignore duplicates

            if (nums[i] == nums[i - 1] + 1) count++;
            else count = 1;

            longest = Math.max(longest, count);
        }

        return longest;
    }

    // Linear Search
    static boolean linearSearch(int[] nums, int target) {
        for (int num : nums) {
            if (num == target) return true;
        }
        return false;
    }

    // Brute Force - O(n²)
    static int bruteSol(int[] nums) {

        if (nums.length == 0)
            return 0;

        int longest = 1;

        for (int num : nums) {
            int current = num;
            int count = 1;

            while (linearSearch(nums, current + 1)) {
                current++;
                count++;
            }

            longest = Math.max(longest, count);
        }

        return longest;
    }

    public static void main(String[] args) {
        int[] nums = {102, 4, 100, 1, 101, 3, 2, 1, 1};

        System.out.println("Longest Consecutive Sequence = " + optimalSol(nums));
    }
}