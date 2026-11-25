package com.java.dsa.binarySearch;

public class L2SearchInsertPosition {

    static int searchInsert(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        int ans = nums.length;

        while (left <= right) {

            int mid = (left + right) / 2;

             if (nums[mid] >= target) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 7, 8, 9, 11};
        int target = 5;

        System.out.println("Ans: " + searchInsert(nums, target));
    }
}
