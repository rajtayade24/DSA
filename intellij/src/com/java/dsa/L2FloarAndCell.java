package com.java.dsa;

public class L2FloarAndCell {

    // arr[index] >= target
    static int floar(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        int ans = -1;

        while (left <= right) {

            int mid = (left + right) / 2;

            if (nums[mid] >= target) {
                ans = nums[mid];
                right = mid - 1;         // look for more small index on left
            } else {
                left = mid + 1;          // look for bigger index on right
            }
        }

        return ans;
    }

    // arr[index] <= target
    static int ceil(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        int ans = -1;

        while (left <= right) {

            int mid = (left + right) / 2;

            if (nums[mid] <= target) {
                ans = nums[mid];
                left = mid + 1;          // look for bigger index on right
            } else {
                right = mid - 1;         // look for more small index on left
            }
        }

        return ans;
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 3, 7, 8, 9, 9, 9, 11};
        int target = 4;

        // arr[index] >= target
        System.out.println("Floar: " + floar(nums, target));

        // arr[index] <= target
        System.out.println("Ceil: " + ceil(nums, target));
    }
}
