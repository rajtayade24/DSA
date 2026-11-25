package com.java.dsa.recursion;

import java.util.ArrayList;
import java.util.List;

public class L8CombinationSum {

    static void findCombinations(
            int index, int[] arr, int target,
            List<List<Integer>> ans, List<Integer> list) {

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
            findCombinations(index, arr, newTarget, ans, list);

            // Backtrack
            list.removeLast();
        }

        // Not pick
        findCombinations(index + 1, arr, target, ans, list);
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 6, 7};

        List<List<Integer>> ans = new ArrayList<>();

        findCombinations(0, arr, 7, ans, new ArrayList<>());

        System.out.println(ans);
    }
}
