package com.java.dsa.array;

import java.util.Arrays;
import java.util.HashMap;

public class L5TwoSum {

    static int[] optimalSOl(int[] nums, int k) {

        Arrays.sort(nums);

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int sum = nums[left] + nums[right];

            if (sum == k)
                return new int[]{left, right};
            else if (sum < k)
                left++;
            else
                right--;
        }
        return new int[]{-1, -1};
    }

    static int[] betterSol(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = k - nums[i];

            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }

            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }

    static int[] bruteSol(int[] nums, int k) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] + nums[j] == k) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }


    public static void main(String[] args) {
        int[] nums = {2, 6, 5, 8, 11};

        int[] result1 = bruteSol(nums, 14);
        System.out.println("Both the index are: i=" + result1[0] + " j=" + result1[1]);

        int[] result2 = betterSol(nums, 14);
        System.out.println("Both the index are: i=" + result2[0] + " j=" + result2[1]);

        int[] result3 = optimalSOl(nums, 14);
        System.out.println("Both the index are: i=" + result3[0] + " j=" + result3[1]);

    }
}
