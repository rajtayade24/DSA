package com.java.dsa.array;

import java.util.*;

public class L22NumberOfSubarraysWithXORAsK {

    // Optimal Solution - Prefix XOR + HashMap
    // Time Complexity : O(n)
    // Space Complexity: O(n)
    static int optimalSol(List<Integer> arr, int k) {

        Map<Integer, Integer> prefixXorMap = new HashMap<>();

        int xor = 0;
        int count = 0;

        // Empty prefix has XOR = 0
        prefixXorMap.put(0, 1);

        for (int num : arr) {

            xor ^= num;

            int required = xor ^ k;
            if (prefixXorMap.containsKey(required)) {
                count += prefixXorMap.get(required);
            }

            prefixXorMap.put(xor,
                    prefixXorMap.getOrDefault(xor, 0) + 1);
        }

        return count;
    }

    // Brute Force: Returns all subarrays whose XOR equals k
    // Time Complexity : O(n³)
    // Space Complexity: O(number of valid subarrays)
    static List<List<Integer>> bruteSol(List<Integer> arr, int k) {

        int n = arr.size();

        List<List<Integer>> answer = new ArrayList<>();

        for (int start = 0; start < n; start++) {

            int xor = 0;
            for (int end = start; end < n; end++) {

                xor ^= arr.get(end);

                if (xor == k) {
                    List<Integer> subArray = new ArrayList<>();
                    for (int i = start; i <= end; i++) {
                        subArray.add(arr.get(i));
                    }
                    answer.add(subArray);
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        List<Integer> arr = Arrays.asList(4, 2, 2, 6, 4);
        int k = 6;

        System.out.println("Subarrays having XOR = " + k + ":");
        System.out.println(bruteSol(arr, k));

        System.out.println();

        System.out.println("Count of subarrays having XOR = " + k + ":");
        System.out.println(optimalSol(arr, k));
    }
}