package com.java.dsa.binarySearch;

public class L6FindMinimumInRotatedArray {

    static int min(int[] nums) {

        int left = 0;
        int right = nums.length - 1;
        int ans = nums[0];

        while (left <= right) {

            int mid = left + (right - left) / 2;

            // Left half is sorted
            if (nums[left] <= nums[mid]) {
                ans = Math.min(ans, nums[left]);
                left = mid + 1;
            }

            // Right half is sorted
            else {
                ans = Math.min(ans, nums[mid]);
                right = mid - 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] nums = {4, 5, 6, 7, 1, 2};

        System.out.println(min(nums));
    }
}