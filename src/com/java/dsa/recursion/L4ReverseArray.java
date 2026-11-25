package com.java.dsa.recursion;

import java.util.Arrays;

public class L4ReverseArray {

    static int[] better(int[] nums, int i) {

        // Base case
        if (i > nums.length / 2)
            return nums;

        // Swap
        return better(nums, i + 1);
    }

    static int[] reverse(int[] nums, int left, int right) {

        // Base case
        if (left > right) return nums;

        // Swap
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;

        return reverse(nums, left + 1, right - 1);
    }

    public static void main(String[] var0) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};

//      int[] ans = reverse(nums, 0, nums.length - 1);
        int[] ans = better(nums, 0);

        System.out.println(Arrays.toString(ans));
    }
}
