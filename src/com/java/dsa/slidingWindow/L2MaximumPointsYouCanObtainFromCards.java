package com.java.dsa.slidingWindow;

public class L2MaximumPointsYouCanObtainFromCards {


    static int selfTry(int[] nums, int k) {

        int lsum = 0;

        for (int i = 0; i < k; i++) {
            lsum += nums[i];
        }

        int maxSum = lsum;

        int l = k - 1, r = nums.length - 1;

        while (l >= 0) {
            lsum += nums[r--];
            lsum -= nums[l--];

            maxSum = Math.max(maxSum, lsum);

        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 1};
        int k = 3;

        System.out.println(selfTry(nums, k));
    }
}
