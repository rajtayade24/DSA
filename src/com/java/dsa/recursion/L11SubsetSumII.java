package com.java.dsa.recursion;

import java.util.*;

public class L11SubsetSumII {

    /// Optimal: Refer to the solution Combination sum solution
    static void subsetSumOptimal(
            int index, List<Integer> list, List<List<Integer>> ans, int[] arr) {

        // Question said: Return the solution in any order.
        Arrays.sort(arr);

        subsetSum(index, list, ans, arr);
    }

    static void subsetSum(
            int index, List<Integer> list, List<List<Integer>> ans, int[] arr) {

        /// IMP: No need of bese case, Because every state of list is already a valid subset.
        ans.add(new ArrayList<>(list));

        for (int i = index; i < arr.length; i++) {

            // Skip duplicates at the same recursion level
            if (i > index && arr[i] == arr[i - 1]) continue;

            // Pick
            list.add(arr[i]);

            subsetSum(i + 1, list, ans, arr);

            list.removeLast();
        }
    }

    /// Refer the Print ALl Subsequence Problem
    static void subsetSum(int index, List<Integer> list, Set<List<Integer>> ans, int[] nums) {
        if (index >= nums.length) {
            // Store a copy of the list to avoid all entries in ans referring to the same mutable list.
            ans.add(new ArrayList<>(list));
            return;
        }

        subsetSum(index + 1, list, ans, nums);

        list.add(nums[index]);

        subsetSum(index + 1, list, ans, nums);

        list.removeLast();
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 2};
//        int[] nums = {0};

        Set<List<Integer>> ansSet = new HashSet<>();

        subsetSum(0, new ArrayList<>(), ansSet, nums);

        System.out.println(ansSet);

        List<List<Integer>> ansSetOptimal = new ArrayList<>();

        subsetSumOptimal(0, new ArrayList<>(), ansSetOptimal, nums);

        System.out.println(ansSetOptimal);
    }
}
