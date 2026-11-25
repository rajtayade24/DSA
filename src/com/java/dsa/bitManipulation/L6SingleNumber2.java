package com.java.dsa.bitManipulation;

import java.util.Arrays;
import java.util.HashMap;

public class L6SingleNumber2 {

    static int mostOptimalSol(int[] nums) {
        int once = 0, twos = 0;

        for (int num : nums) {
            once = (once ^ num) & ~twos;
            twos = (twos ^ num) & ~once;
        }
        return once;
    }

    static int optimalSol(int[] nums) {

        int ans = 0;

        // Check all 32 bits
        for (int i = 0; i < 32; i++) {
            int count = 0;

            // Count how many numbers have the i-th bit set
            for (int num : nums) {
                if ((num & (1 << i)) != 0) {
                    count++;
                }
            }

            // If count is not divisible by 3, this bit belongs to the answer
            if (count % 3 != 0) {
                ans = ans | (1 << i);
            }
        }

        return ans;
    }

    static int betterSol(int[] nums) {
        int n = nums.length;

        Arrays.sort(nums);

        int i = 1;
        while (i < n) {
            if (nums[i - 1] != nums[i] || nums[i] != nums[i + 1]) {
                return nums[i - 1];
            }
            i += 3;
        }

        return nums[n - 1];
    }

    static int sol(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Integer key : map.keySet()) {
            if (map.get(key) == 1) return key;
        }

        return 0;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 1, 0, 1, 99};

        System.out.println("Ans: " + sol(nums));
        System.out.println("Ans: " + betterSol(nums));
        System.out.println("Ans: " + optimalSol(nums));
        System.out.println("Ans: " + mostOptimalSol(nums));
    }
}
