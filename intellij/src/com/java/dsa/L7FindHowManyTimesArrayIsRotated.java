package com.java.dsa;

public class L7FindHowManyTimesArrayIsRotated {

    static int countRotation(int[] nums) {

        int right = nums.length - 1;
        int left = 0;
        int ans = nums[0];
        int index = 0;

        while (left <= right) {

            int mid = (left + right) / 2;

            // left half is sorted
            if (nums[left] <= nums[mid]) {
                if (nums[left] <= ans) {
                    ans = nums[left];
                    index = left;
                }
                left = mid + 1;
            }
            // right half is sorted
            else {
                if (nums[mid] <= ans) {
                    ans = nums[mid];
                    index = mid;
                }
                right = right - 1;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 1, 2};

        System.out.println(countRotation(nums));
    }
}
