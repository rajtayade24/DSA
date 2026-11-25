package com.java.dsa.array;

public class L3FindMIssingNumber {

    static int betterSol(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] + 1 != nums[i + 1]) {
                return nums[i] + 1;
            }
        }
        return -1;
    }

    static int sol(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return -1;
    }

    // between 1 to n
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 8, 9};

        System.out.println("Ans: " + sol(nums));
        System.out.println("Ans: " + betterSol(nums));
    }
}
