package com.java.dsa.binarySearch;

public class L14FindSmallestDivisor {

    static int max(int[] nums) {
        int ans = Integer.MIN_VALUE;
        for (int el : nums) ans = Math.max(ans, el);
        return ans;
    }

    static int linearSearch(int[] nums, int threshold) {

        for (int divisor = 1; divisor <= max(nums); divisor++) {

            int cnt = 0;
            for (int num : nums) {
                cnt += (int) Math.ceil((double) num / divisor);
            }
            if (cnt <= threshold)
                return divisor;
        }
        return -1;
    }

    static int binarySearch(int[] nums, int threshold) {

        int left = 1, right = max(nums);

        int ans = Integer.MAX_VALUE;
        while (left <= right) {
            int divisor = (left + right) / 2;

            int count = 0;
            for (int num : nums) {
                count += (int) Math.ceil((double) num / divisor);
            }
            if (count <= threshold) {
                ans = Math.min(ans, divisor);
                right = divisor - 1;
            } else left = divisor + 1;

        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 5, 9};
        int threshold = 6;

        System.out.println("Ans: " + linearSearch(nums, threshold)); // 5
        System.out.println("Ans: " + binarySearch(nums, threshold)); // 5

    }
}
