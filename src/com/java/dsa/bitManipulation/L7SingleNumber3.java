package com.java.dsa.bitManipulation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class L7SingleNumber3 {

    static int[] optimalSol(int[] nums) {

        int xor = 0;
        for (int num : nums) xor ^= num;

        int rightMost = (xor & (xor - 1)) ^ xor;

        int b1 = 0, b2 = 0;
        for (int num : nums) {
            if ((num & rightMost) != 0) b1 ^= num;
            else b2 ^= num;
        }

        return new int[]{b1, b2};
    }

    static List<Integer> bruteSol(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> ans = new ArrayList<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Integer key : map.keySet()) {
            if (map.get(key) == 1) ans.add(key);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 3, 2, 5};

        System.out.println(bruteSol(nums));

        int[] ans = optimalSol(nums);
        System.out.println(ans[0] + " " + ans[1]);
    }
}
