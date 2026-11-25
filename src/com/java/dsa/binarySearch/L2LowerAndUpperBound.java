package com.java.dsa.binarySearch;

public class L2LowerAndUpperBound {

    // arr[index] >= target
    public static int lowerBound(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        int ans = nums.length;

        while (left <= right) {

            int mid = (left + right) / 2;

            if (nums[mid] >= target) {
                ans = mid;
                right = mid - 1;         // look for more small index on left
            } else {
                left = mid + 1;          // look for bigger index on right
            }
        }

        return ans;
    }

    // arr[index] > target
    public static int upperBound(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        int ans = nums.length;

        while (left <= right) {

            int mid = (left + right) / 2;

            if (nums[mid] > target) {
                ans = mid;
                right = mid - 1;         // look for more small index on left
            } else {
                left = mid + 1;          // look for bigger index on right
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 3, 7, 8, 9, 9, 9, 11};
        int target = 7;

        // arr[index] >= target
        System.out.println("Lower bound: " + lowerBound(nums, target));

        // arr[index] >target
        System.out.println("Upper bound: " + upperBound(nums, target));
    }
}
