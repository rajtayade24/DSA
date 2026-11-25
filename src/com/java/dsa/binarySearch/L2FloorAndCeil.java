package com.java.dsa.binarySearch;

public class L2FloorAndCeil {

    // Floor = largest element <= target
    static int floor(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        int ans = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] <= target) {
                ans = nums[mid];
                left = mid + 1;          // look for a bigger value on right
            } else {
                right = mid - 1;         // look for a smaller value on left
            }
        }

        return ans;
    }

    // Ceil = smallest element >= target
    static int ceil(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        int ans = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] >= target) {
                ans = nums[mid];
                right = mid - 1;         // look for a smaller value on left
            } else {
                left = mid + 1;          // look for a bigger value on right
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 3, 7, 8, 9, 9, 9, 11};
        int target = 4;

        System.out.println("Floor: " + floor(nums, target));
        System.out.println("Ceil: " + ceil(nums, target));
    }
}