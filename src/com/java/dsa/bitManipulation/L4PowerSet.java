package com.java.dsa.bitManipulation;

import java.util.ArrayList;
import java.util.List;

public class L4PowerSet {

    static List<List<Integer>> bruteSol(int[] nums) {
        int n = nums.length;

        int subsets = 1 << n;
        List<List<Integer>> ans = new ArrayList<>();

        for (int num = 0; num < subsets; num++) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if ((num & (1 << i)) != 1)
                    list.add(nums[i]);
            }
            ans.add(list);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3}; // [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
//        int[] nums = {0}; // [[], [0]]

        System.out.println("Ans: " + bruteSol(nums));
    }
}
