package com.java.dsa.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class L11LeadersInArray {

    // Optimal Solution - O(n)
    static List<Integer> optimalSol(int[] nums) {

        List<Integer> ans = new ArrayList<>();
        int max = Integer.MIN_VALUE;

        // Traverse from right to left
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] > max) {
                ans.add(nums[i]);
                max = nums[i];
            }
        }

        // Reverse because we collected leaders from right to left
        Collections.reverse(ans);

        return ans;
    }

    // Brute Force Solution - O(n²)
    static List<Integer> bruteSol(int[] nums) {

        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {

            boolean isLeader = true;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] < nums[j]) {
                    isLeader = false;
                    break;
                }
            }
            if (isLeader)
                ans.add(nums[i]);
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] nums = {3, 55, 5, 62, 54, 23, 32, 42};

        List<Integer> ans = optimalSol(nums);

        System.out.println("Leaders in the array:");

        for (int num : ans) {
            System.out.print(num + " ");
        }
    }
}