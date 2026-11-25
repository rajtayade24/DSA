package com.java.dsa.greedyAlgorithm;

public class L5JumpGameII {

    static int jump(int[] nums) {

        int left = 0, right = 0, jumps = 0;

        while (right < nums.length-1) {

            int farthest = 0;
            for (int i = left; i <= right; i++) {
                farthest = Math.max(i + nums[i], farthest);
            }
            left = right + 1;
            right = farthest;

            jumps++;
        }
        return jumps;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 4,1,1,1, 2};

        System.out.println(jump(nums));
    }
}
