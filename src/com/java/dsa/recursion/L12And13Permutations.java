package com.java.dsa.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L12And13Permutations {

    // Optimal
    static void findPermutationsOptimal(
            int index, List<List<Integer>> ans, int[] arr) {

        // Base case
        if (index == arr.length) {
            ans.add(Arrays.stream(arr).boxed().toList());
            return;
        }

        for (int i = index; i < arr.length; i++) {
            // Swap
            int temp = arr[index];
            arr[index] = arr[i];
            arr[i] = temp;

            // Recursion
            findPermutationsOptimal(index + 1, ans, arr);

            // Backtrack: swap back
            temp = arr[index];
            arr[index] = arr[i];
            arr[i] = temp;
        }
    }

    static void findPermutations(
            List<Integer> list, boolean[] freq, List<List<Integer>> ans, int[] arr) {

        // Base case
        if (list.size() == arr.length) {
            ans.add(new ArrayList<>(list));
            return;
        }

        // Try every element
        for (int i = 0; i < arr.length; i++) {

            if (!freq[i]) {
                // Pick
                freq[i] = true;
                list.add(arr[i]);

                findPermutations(list, freq, ans, arr);

                // Backtrack
                list.removeLast();
                freq[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};

        List<List<Integer>> ans = new ArrayList<>();

        findPermutations(new ArrayList<>(), new boolean[arr.length], ans, arr);

        System.out.println(ans);

        List<List<Integer>> optimalAns = new ArrayList<>();

        findPermutationsOptimal(0, optimalAns, arr);

        System.out.println(optimalAns);
    }
}
