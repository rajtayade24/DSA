package com.java.dsa.array;

import java.util.HashMap;

public class L7MajorityElementMooresVotingAlgorithm {

    // Optimal Solution - Moore's Voting Algorithm - O(n)
    static int optimalSol(int[] arr) {

        int count = 0;
        int element = 0;

        // Step 1: Find Candidate
        for (int num : arr) {

            if (count == 0) {
                element = num;
                count = 1;
            } else if (num == element) {
                count++;
            } else {
                count--;
            }
        }

        // Step 2: Verify Candidate
        count = 0;

        for (int num : arr) {
            if (num == element) {
                count++;
            }
        }

        if (count > arr.length / 2) {
            return element;
        }

        return -1;
    }

    // Better Solution - HashMap - O(n)
    static int betterSol(int[] arr) {

        HashMap<Integer, Integer> map = new HashMap<>();

        // Store frequencies
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int max = 0;
        int target = -1;

        // Find element with maximum frequency
        for (var entry : map.entrySet()) {

            if (entry.getValue() > max) {
                max = entry.getValue();
                target = entry.getKey();
            }
        }

        return target;
    }

    // Brute Force Solution - O(n²)
    static int bruteSol(int[] arr) {

        int n = arr.length;

        int max = 0;
        int target = -1;

        for (int i = 0; i < n; i++) {

            int count = 0;

            for (int j = 0; j < n; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                }
            }

            if (count > max) {
                max = count;
                target = arr[i];
            }
        }

        return target;
    }

    public static void main(String[] args) {

        int[] arr = {
                1, 2, 3, 2, 3, 2, 2, 2,
                2, 2, 2, 1, 2, 1, 1, 2
        };

        System.out.println("Majority Element: " + optimalSol(arr));
    }
}