package com.java.dsa.recursion;

import java.util.*;

public class L9CombinationSumII {

    static void findCombinationsOptimal(
            int index, int[] arr, int target,
            List<List<Integer>> ans, List<Integer> list) {

        // Base case
        if (target == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }

        // Pick
        for (int i = index; i < arr.length; i++) {

            // Skip duplicates at the same recursion level
            if (i > index && arr[i] == arr[i - 1]) continue;

            // Array is sorted
            if (arr[i] > target) break;

            // Pick
            list.add(arr[i]);

            int newTarget = target - arr[i];
            findCombinationsOptimal(i + 1, arr, newTarget, ans, list);

            list.removeLast();
        }
    }

    static void findCombinations(
            int index, int[] arr, int target,
            Set<List<Integer>> ans, List<Integer> list) {

        // Base case
        if (index == arr.length) {
            if (target == 0) {
                ans.add(new ArrayList<>(list));
            }
            return;
        }

        // Pick
        if (arr[index] <= target) {
            list.add(arr[index]);

            int newTarget = target - arr[index];
            findCombinations(index + 1, arr, newTarget, ans, list);

            // Backtrack
            list.removeLast();
        }

        // Not pick
        findCombinations(index + 1, arr, target, ans, list);
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 2, 2};

        Set<List<Integer>> ans = new HashSet<>();

        findCombinations(0, arr, 4, ans, new ArrayList<>());

        System.out.println("Solution: " + ans);

        List<List<Integer>> ansOpt = new ArrayList<>();
        Arrays.sort(arr);

        findCombinationsOptimal(0, arr, 4, ansOpt, new ArrayList<>());

        System.out.println("Optimal Solution: " + ansOpt);
    }
}
