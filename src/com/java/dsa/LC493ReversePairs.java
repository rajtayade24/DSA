package com.java.dsa;

import java.util.TreeMap;

public class LC493ReversePairs {

    static int selfTry(int[] nums) {

        // Time limit exceeded
        TreeMap<Long, Integer> map = new TreeMap<>();

        int count = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            int num = nums[i];

            for (int value : map.headMap((long) num).values()) {
                count += value;
            }

            map.put((long) num * 2, map.getOrDefault((long) num * 2, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = {2, 4, 3, 5, 1};

        System.out.println(selfTry(nums));
    }
}
