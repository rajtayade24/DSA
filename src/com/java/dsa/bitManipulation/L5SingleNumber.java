package com.java.dsa.bitManipulation;

public class L5SingleNumber {

    static int sol(int[] nums) {
        int xor = 0;
        for (int i = 0; i < nums.length; i++) {
            xor = xor ^ nums[i];
        }
        return xor;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 1};

        System.out.println("Ans: " + sol(nums));
    }
}
