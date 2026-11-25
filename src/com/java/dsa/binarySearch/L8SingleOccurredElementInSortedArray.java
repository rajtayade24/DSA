package com.java.dsa.binarySearch;

public class L8SingleOccurredElementInSortedArray {

    static int singleElement(int[] nums) {

        int n = nums.length;

        if (n == 1) return nums[0];

        if (nums[0] != nums[1]) return nums[0];

        if (nums[n - 1] != nums[n - 2]) return nums[n - 1];

        int left = 1;
        int right = n - 2;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            // Single element found
            if (nums[mid - 1] != nums[mid] &&
                    nums[mid] != nums[mid + 1]) {
                return nums[mid];
            }

            // Left half contains the single element
            if ((mid % 2 == 1 && nums[mid - 1] == nums[mid]) ||
                    (mid % 2 == 0 && nums[mid] == nums[mid + 1])) {

                left = mid + 1;
            }

            // Right half contains the single element
            else {
                right = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 3, 3, 4, 4, 8, 8};
//        int[] nums = {3, 7, 7, 10, 10, 11, 11};

        System.out.println("Single appeared element in the array is: " + singleElement(nums));
    }
}
