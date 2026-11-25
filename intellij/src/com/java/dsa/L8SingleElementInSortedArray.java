package com.java.dsa;

public class L8SingleElementInSortedArray {

    static int singleElement(int[] nums) {
        int n = nums.length;

        if (nums.length == 1) return nums[0];
        if (nums[0] != nums[1]) return nums[0];
        if (nums[])

        int left = 1;
        int right = n - 1;

        while (left <= right) {

            int mid = (left + right) / 2;

            System.out.println(nums[left] + " " + nums[mid] + " " + nums[right]);

            if (nums[mid - 1] == nums[mid] || nums[mid] == nums[mid + 1]) {

            } else {
                return nums[mid];
            }
//            if ((mid + 1) % 2 != 0) {
//                if (nums[mid - 1] != nums[mid]) {
//                    return nums[mid];
//                } else {
//                    left = mid + 1;
//                }
//            } else {
//                if (nums[mid] == nums[mid + 1]) {
//                    return nums[mid];
//                } else {
//                    right = mid - 1;
//                }
//            }
        }

        return -1;
    }

    public static void main(String[] args) {
//        int[] nums = {1, 1, 2, 3, 3, 4, 4, 8, 8};
        int[] nums = {3, 7, 7, 10, 10, 11, 11};

        System.out.println("Single appeared element in the array is: " + singleElement(nums));
    }
}
