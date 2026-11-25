package com.java.dsa.array;

import java.util.Arrays;

public class L2RightRotateArray {

    static void reverse(int[] arr, int left, int right) {
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    static void optimalSol(int[] arr, int k) {

        int n = arr.length;
        k %= n;

        reverse(arr, 0, n - 1);
        reverse(arr, 0, k - 1);
        reverse(arr, k, n - 1);
    }

    static int[] sol(int[] nums, int k) {
        int n = nums.length;

        k %= n;
        if (k == 0)
            return nums;

        int[] temp = new int[k];

        // Store last k elements
        for (int i = 0; i < k; i++) {
            temp[i] = nums[n - k + i];
        }

        // Shift remaining elements
        for (int i = n - 1; i >= k; i--) {
            nums[i] = nums[i - k];
        }

        // Copy temp to beginning
        for (int i = 0; i < k; i++) {
            nums[i] = temp[i];
        }

        return nums;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 3, 4, 5, 6, 7, 8, 9};
        int[] nums2 = {1, 3, 4, 5, 6, 7, 8, 9};

        int k = 3;

        System.out.println(Arrays.toString(sol(nums1, k)));

        optimalSol(nums2, k);
        System.out.println(Arrays.toString(nums2));
    }
}
