package com.java.dsa.array;

import java.util.HashMap;

public class L4LongestSubarrayWithSumK {

    // This approach works only when the array contains positive numbers.
    // If negative numbers exist, this algorithm will fail.

    static int optimalSolBest(int[] nums, int k) {

        int left = 0, right = 0;
        int sum = 0, maxLength = 0;

        while (right < nums.length) {

            sum += nums[right]; // Expand the window

            if (left <= right && sum > k) { // Shrink the window one once if sum becomes greater than k because we need to get better window size
                sum -= nums[left];
                left++;
            }

            if (sum == k) { // Check if current window sum is equal to k
                maxLength = Math.max(maxLength, right - left + 1);
            }

            right++;
        }

        return maxLength;
    }

    static int optimalSol(int[] nums, int k) {

        int left = 0, right = 0;
        int sum = 0, maxLength = 0;

        while (right < nums.length) {

            sum += nums[right]; // Expand the window

            while (left <= right && sum > k) { // Shrink the window if sum becomes greater than k
                sum -= nums[left];
                left++;
            }

            if (sum == k) { // Check if current window sum is equal to k
                maxLength = Math.max(maxLength, right - left + 1);
            }

            right++;
        }

        return maxLength;
    }

    // O(n)
    static int prefixSumHashing(int[] nums, int k) {

        HashMap<Long, Integer> preSumMap = new HashMap<>();

        long sum = 0;
        int maxLength = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (sum == k) // Subarray starts from index 0
                maxLength = i + 1;

            long rem = sum - k;

            if (preSumMap.containsKey(rem)) {
                int len = i - preSumMap.get(rem);
                maxLength = Math.max(maxLength, len);
            }

            // Store first occurrence only
            preSumMap.putIfAbsent(sum, i);
        }

        return maxLength;
    }

    // O(n²)
    static int bruteForce(int[] nums, int k) {

        int maxLength = 0;

        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    maxLength = Math.max(maxLength, j - i + 1);
                }
            }
        }

        return maxLength;
    }


    public static void main(String[] args) {

        int[] nums = {1, 3, 2, 1, 1, 1, 1, 4, 2, 3};

        int k = 5;

        System.out.println("Brute Force : " + bruteForce(nums, k));
        System.out.println("Better      : " + prefixSumHashing(nums, k));
        System.out.println("Optimal     : " + optimalSol(nums, k));
        System.out.println("Optimal Best: " + optimalSolBest(nums, k));
    }
}