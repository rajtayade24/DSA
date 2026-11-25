package com.java.dsa.array;

import java.util.HashMap;

public class L17CountSubarrayWithSumK {

    // Optimal - Sliding Window
    // Works only for positive numbers
    static int optimalSol(int[] nums, int k) {

        int n = nums.length;

        int left = 0;
        int right = 0;
        int sum = 0;
        int count = 0;

        while (right < n) {
            sum += nums[right];
            while (sum > k && left <= right) {
                sum -= nums[left];
                left++;
            }

            if (sum == k) count++;
            right++;
        }

        return count;
    }

    // Better Solution - Prefix Sum + HashMap - O(n)
    static int betterSol(int[] nums, int k) {

        HashMap<Long, Integer> preSumMap = new HashMap<>();

        long sum = 0;
        int count = 0;

        // Important: prefix sum 0 appears once
        preSumMap.put(0L, 1);

        for (int num : nums) {
            sum += num;
            long rem = sum - k;
            if (preSumMap.containsKey(rem)) {
                count += preSumMap.get(rem);
            }

            preSumMap.put(sum, preSumMap.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

    // Brute Force - O(n²)
    static int bruteSol(int[] nums, int k) {

        int n = nums.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                if (sum == k) count++;
            }
        }

        return count;
    }


    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 1, 1, 1, 1, 4, 2, 3};
        int k = 3;

        System.out.println("Brute Force : " + bruteSol(nums, k));
        System.out.println("Better      : " + betterSol(nums, k));
        System.out.println("Optimal     : " + optimalSol(nums, k));
    }
}