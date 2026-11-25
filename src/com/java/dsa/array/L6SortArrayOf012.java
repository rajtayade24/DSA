package com.java.dsa.array;

import java.util.Arrays;

public class L6SortArrayOf012 {

    // Optimal Solution (Dutch National Flag Algorithm)
    static void optimalSol(int[] nums) {

        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while (mid <= high) {

            if (nums[mid] == 0) {
                swap(nums, low, mid);
                low++;
                mid++; 
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                swap(nums, mid, high);
                high--;
            }
        }
    }

    // Swap Method
    static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // Brute Force Solution (Counting Method)
    static void bruteSol(int[] nums) {

        int n = nums.length;
        int zero = 0, one = 0, two = 0;

        // Count 0s, 1s, and 2s
        for (int num : nums) {
            if (num == 0)
                zero++;
            else if (num == 1)
                one++;
            else
                two++;
        }

        for (int i = 0; i < zero; i++) // Fill 0s
            nums[i] = 0;
        for (int i = zero; i < zero + one; i++) // Fill 1s
            nums[i] = 1;
        for (int i = zero + one; i < n; i++) // Fill 2s
            nums[i] = 2;
    }

    public static void main(String[] args) {

        int[] nums = {0, 2, 1, 2, 2, 1, 1, 2, 1, 1, 0, 0,
                1, 2, 1, 1, 1, 1, 0, 0, 0, 0, 1, 2};

        optimalSol(nums);

        System.out.println(Arrays.toString(nums));
    }
}
