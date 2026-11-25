package com.java.dsa.greedyAlgorithm;

public class L4JumpGame {

    static boolean canJump(int[] nums) {
        int maxIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i > maxIndex)
                return false;

            maxIndex = Math.max(maxIndex, i + nums[i]);
        }
        return true;
    }

    public static void main(String[] args) {
//        int[] nums = {2, 3, 1, 1, 4};
        int[] nums = {1, 2, 3, 1, 1, 0, 2, 5};

        System.out.println(canJump(nums));
    }
}
