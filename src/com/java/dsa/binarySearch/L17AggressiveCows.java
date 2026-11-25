package com.java.dsa.binarySearch;

import java.util.Arrays;

public class L17AggressiveCows {

    static int linearSearch(int[] nums, int cows) {
        Arrays.sort(nums);
        int n = nums.length;

        for (int dist = 1; dist <= nums[n - 1] - nums[0]; dist++) {
            if (!canWePlace(nums, cows, dist)) {
                return dist - 1;
            }
        }

        return -1;
    }

    static boolean canWePlace(int[] nums, int cows, int dist) {
        int cnt = 1; // first cow
        int last = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - last >= dist) {
                cnt++;
                last = nums[i];
            }
            if (cnt >= cows) return true;
        }
        return false;
    }

    static int binarySearch(int[] nums, int cows) {
        Arrays.sort(nums);
        int n = nums.length;

        int left = 1;
        int right = nums[n - 1] - nums[0];
        while (left <= right) {
            int mid = (left + right) / 2;

            if (canWePlace(nums, cows, mid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        int[] nums = {0, 3, 4, 7, 10, 9};
        int cows = 4; // 3
//        int[] nums = {4, 2, 1, 3, 6};
//        int cows = 2; // 5
//        int[] nums = {10, 1, 2, 7, 5};
//        int cows = 3;

        System.out.println("Ans: " + linearSearch(nums, cows));
        System.out.println("Ans: " + binarySearch(nums, cows));
    }
}
