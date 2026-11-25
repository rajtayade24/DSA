package com.java.dsa;

public class L6FindMinimumInRotatedArray {

    static int min(int[] nums) {

        int right = nums.length - 1;
        int left = 0;
        int ans = nums[0];

        while (left <= right) {

            int mid = (left + right) / 2;

            // left half is sorted
            if (nums[left] <= nums[mid]) {
                if (nums[left] <= ans) ans = nums[left];
                left = mid + 1;
            }
            // right half is sorted
            else {
                if (nums[mid] <= ans) ans = nums[mid];
                right = right - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {

        int[] nums = {4, 5, 6, 7,  1, 2};

        System.out.println(min(nums));
    }
}
