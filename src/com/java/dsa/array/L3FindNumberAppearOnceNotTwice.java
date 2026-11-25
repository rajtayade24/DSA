package com.java.dsa.array;

import java.util.HashMap;

public class L3FindNumberAppearOnceNotTwice {

    static int usingXOR(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        return xor;
    }

    static int sol(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i += 2) {
            if (nums[i] != nums[i + 1])
                return nums[i];
        }

        return nums[n - 1];
    }

    static int usingHashMap(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int key : map.keySet()) {
            if (map.get(key) == 1) {
                return key;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 4, 4, 5, 6, 6, 7, 7, 9, 9};

        System.out.println("Ans: " + usingHashMap(nums));
        System.out.println("Ans: " + sol(nums));
        System.out.println("Ans: " + usingXOR(nums));
    }
}
