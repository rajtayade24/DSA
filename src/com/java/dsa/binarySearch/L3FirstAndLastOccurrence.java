package com.java.dsa.binarySearch;

public class L3FirstAndLastOccurrence {

    // Find the first occurrence of target
    static int firstOccurrence(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        int ans = -1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                ans = mid;
                right = mid - 1;          // search for earlier occurrence
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }

    // Find the last occurrence of target
    static int lastOccurrence(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        int ans = -1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                ans = mid;
                left = mid + 1;           // search for later occurrence
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }

    // Lower Bound = first index where nums[index] >= target
    public static int lowerBound(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        int ans = nums.length;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] >= target) {
                ans = mid;
                right = mid - 1;          // search on left
            } else {
                left = mid + 1;           // search on right
            }
        }

        return ans;
    }

    // Upper Bound = first index where nums[index] > target
    public static int upperBound(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        int ans = nums.length;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] > target) {
                ans = mid;
                right = mid - 1;          // search on left
            } else {
                left = mid + 1;           // search on right
            }
        }

        return ans;
    }

    // Find first and last occurrence of target
    static int[] searchRange(int[] nums, int target) {

        if (nums.length == 0) {
            return new int[]{-1, -1};
        }

        int lb = lowerBound(nums, target);

        // Target does not exist
        if (lb == nums.length || nums[lb] != target) {
            return new int[]{-1, -1};
        }

        int ub = upperBound(nums, target);

        return new int[]{lb, ub - 1};
    }

    // Count the number of occurrences of target
    static int countOccurrence(int[] nums, int target) {

        int lb = lowerBound(nums, target);

        // Target does not exist
        if (lb == nums.length || nums[lb] != target) {
            return 0;
        }

        int ub = upperBound(nums, target);

        return ub - lb;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 4, 5, 6, 8, 8, 8, 9};
        int target = 8;

        // Using firstOccurrence() and lastOccurrence()
        System.out.println("First Occurrence: " + firstOccurrence(nums, target));
        System.out.println("Last Occurrence: " + lastOccurrence(nums, target));

        // Using lowerBound() and upperBound()
        System.out.println("Lower Bound: " + lowerBound(nums, target));
        System.out.println("Upper Bound: " + upperBound(nums, target));

        // Search range
        int[] ans = searchRange(nums, target);

        System.out.println("Search Range: [" + ans[0] + ", " + ans[1] + "]");

        // Count occurrences
        System.out.println("Count Occurrence: " + countOccurrence(nums, target));
    }
}