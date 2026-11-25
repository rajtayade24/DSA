package com.java.dsa;


public class L1BInarySearch {

    static void binarySearch(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {

            int mid = (left + right) / 2;

            if (nums[mid] == target) {
                System.out.println("Element found at index: " + mid);
                return;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println("Element not found");
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 3, 7, 8, 9, 9, 9, 11};
        int target = 9;

        binarySearch(nums, target);
    }
}
