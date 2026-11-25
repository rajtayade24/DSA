package com.java.dsa.array;

import java.util.*;

public class NextPermutation {

    static void nextPermutation(int[] nums) {

        int n = nums.length;
        int index = -1;

        // Step 1: Find the break point
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                index = i;
                break;
            }
        }

        // Step 2: If no breakpoint exists, reverse the entire array
        if (index == -1) {
            reverse(nums, 0, n - 1);
            return;
        }

        // Step 3: Find the next greater element from the right
        for (int i = n - 1; i > index; i--) {
            if (nums[i] > nums[index]) {
                swap(nums, i, index);
                break;
            }
        }

        // Step 4: Reverse the remaining part
        reverse(nums, index + 1, n - 1);
    }

    // Swap two elements
    static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // Reverse array from start to end
    static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 5, 4, 3, 1};

        nextPermutation(nums);

        System.out.println(Arrays.toString(nums));
    }
}