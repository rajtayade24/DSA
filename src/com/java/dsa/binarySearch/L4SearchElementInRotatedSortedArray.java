package com.java.dsa.binarySearch;

// [4, 5, 6, 7, 0, 1, 2]
// target = 0
// ans = 4 (index)
public class L4SearchElementInRotatedSortedArray {

    // left rotated
    static int search(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {

            int mid = (left + right) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            // left half sorted
            if (nums[left] <= nums[mid]) {
                // found in left half
                if (nums[left] <= target && target <= nums[mid])
                    right = mid - 1;
                else
                    left = mid + 1;
            }

            // right half sorted
            else {
                // found in right half
                if (nums[mid] <= target && target <= nums[right])
                    left = mid + 1;
                else
                    right = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;

        System.out.println("Result: " + search(nums, target));

    }
}
