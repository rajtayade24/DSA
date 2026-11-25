package com.java.dsa;

public class LC1752CheckIfArrayIsSortedAndRotated {

    static boolean standard(int[] nums) {
        int n = nums.length;
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] > nums[(i + 1) % n]) {
                cnt++;
            }
            if (cnt > 1) {
                return false;
            }
        }

        return true;
    }

    static boolean selfTry(int[] nums) {
        int n = nums.length;

        int low = nums[0], high = -1;
        int cnt = 0;

        int i = 0;
        while (i < n - 1 && cnt == 0) {
            if (nums[i] > nums[i + 1]) {
                cnt++;
                high = nums[i];
            }
            i++;
        }

        if (high == -1)
            return true;
        if (nums[i] > low && nums[i] < high) return false;

        for (int index = i; index < n - 1; index++) {
            if (nums[index] > nums[index + 1]) {
                cnt++;
            }
            if (nums[index] > low && nums[index] < high) {
                return false;
            }
        }

        if (cnt > 1)
            return false;

        low = nums[i];
        high = nums[n - 1];
        for (int index = 0; index < i; index++) {
            if (nums[index] > low && nums[index] < high) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 2};

        System.out.println(selfTry(nums));
    }
}
