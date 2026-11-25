package com.java.dsa;

public class LC287FindTheDuplicateNumber {

    static int selfTry(int[] nums) {
        int n = nums.length;

        int slow = 0, fast = 1;

        while (nums[slow] != nums[fast]) {
            if (slow + 1 >= n) slow = 0;
            else slow = slow + 1;

            if (fast + 2 >= n) fast = 0;
            else fast = fast + 2;
        }
        return nums[slow];

    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 2, 2};

        System.out.println(selfTry(nums));
    }
}
