package com.java.dsa.array;

import java.util.Arrays;

public class L2MoveZerosToEnd {

    static int[] sol(int[] nums) {
        int idx = 0;

        // Move all non-zero elements
        for (int num : nums) {
            if (num != 0) {
                nums[idx++] = num;
            }
        }
        // Fill remaining positions with 0
        while (idx < nums.length) {
            nums[idx++] = 0;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {1, 0, 3, 0, 4, 0, 5, 6, 7, 8, 0, 9};

        System.out.print(Arrays.toString(sol(nums)));

    }
}
