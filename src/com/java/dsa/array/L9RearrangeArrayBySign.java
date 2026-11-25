package com.java.dsa.array;

import java.util.ArrayList;
import java.util.Arrays;

public class L9RearrangeArrayBySign {

    // Optimal Solution (Equal positives and negatives)
    static int[] optimalSol(int[] nums) {

        int[] ans = new int[nums.length];

        int posIndex = 0;
        int negIndex = 1;

        for (int num : nums) {
            if (num >= 0) {
                ans[posIndex] = num;
                posIndex += 2;
            } else {
                ans[negIndex] = num;
                negIndex += 2;
            }
        }

        return ans;
    }

    // Helper Method
    static int[] helper(int[] nums, ArrayList<Integer> bigger, ArrayList<Integer> smaller) {

        for (int i = 0; i < smaller.size(); i++) {
            nums[i * 2] = bigger.get(i);
            nums[i * 2 + 1] = smaller.get(i);
        }

        int index = smaller.size() * 2;

        for (int i = smaller.size(); i < bigger.size(); i++) {
            nums[index++] = bigger.get(i);
        }

        return nums;
    }

    // Brute Force Solution (Handles unequal positives and negatives)
    static int[] bruteSol(int[] nums) {

        ArrayList<Integer> positive = new ArrayList<>();
        ArrayList<Integer> negative = new ArrayList<>();

        for (int num : nums) {
            if (num >= 0) {
                positive.add(num);
            } else {
                negative.add(num);
            }
        }

        if (positive.size() >= negative.size()) {
            return helper(nums, positive, negative);
        } else {
            return helper(nums, negative, positive);
        }
    }

    public static void main(String[] args) {

        int[] nums = {3, 1, -2, -5, 2, -4};

        int[] result = bruteSol(nums);

        System.out.println(Arrays.toString(result));

        // Output:
        // [3, -2, 1, -5, 2, -4]
    }
}