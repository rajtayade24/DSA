package com.java.dsa;

import java.util.Arrays;

public class LC1838FrequencyoftheMostFrequentElement {

    static int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);

        int left = 0;
        long windowSum = 0;
        int ans = 0;

        for (int right = 0; right < nums.length; right++) {
            windowSum += nums[right];

            while ((long) nums[right] * (right - left + 1) - windowSum > k) {
                windowSum -= nums[left];
                left++;
            }

            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 4};
        int k = 5;

        System.out.println(maxFrequency(nums,k));
    }
}
