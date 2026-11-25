package com.java.dsa.binarySearch;

import java.util.ArrayList;
import java.util.List;

public class L9FindPeakElement {

    static List<Integer> linearSearch(int[] nums) {
        int n = nums.length;

        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if ((i == 0 || nums[i - 1] < nums[i])
                    && (i == n - 1 || nums[i] > nums[i + 1])) {
                ans.add(nums[i]);
            }
        }

        return ans;
    }

    /// Finding all peak element is not possible using binary search
    static int binarySearch(int[] nums) {
        int n = nums.length;

        if (n== 1) return 0;
        if (nums[0] > nums[1]) return 0;
        if (nums[n - 1] > nums[n - 2]) return n - 1;

        int left = 1, right = n - 2;
        while (left <= right) {
            int mid = (left + right) / 2;

            if (nums[mid - 1] < nums[mid] && nums[mid] > nums[mid + 1]) {
                return mid;
            }
            // left sorted
            if (nums[mid - 1] <= nums[mid]) left = mid + 1;
            else right = mid - 1;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 3, 4, 5, 6, 7, 8, 5, 1};

        System.out.println("Ans: " + linearSearch(nums));
        System.out.println("Ans: " + binarySearch(nums));
    }
}
