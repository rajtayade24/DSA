package com.java.dsa.array;

public class L1SecondLargest {

    static int sol(int[] nums) {
        if (nums.length < 2)
            return -1;

        int largest = nums[0];
        int secondLargest = -1; // assuming array does not contain negative numbers

        for (int num : nums) {
            if (largest < num) {
                secondLargest = largest;
                largest = num;
            }
        }
        return secondLargest;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 6, 7, 4, 7, 8, 7, 9, 3};

        System.out.println("Second largest element: " + sol(nums));
    }
}
