package com.java.dsa.array;

import java.util.*;

public class L21FourSum {

    // Optimal Solution - Sorting + Two Pointers
    // Time Complexity: O(n^3)
    // Space Complexity: O(1) (excluding answer)
    static List<List<Integer>> optimalSol(List<Integer> arr, int target) {

        int n = arr.size();

        Collections.sort(arr);

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < n - 3; i++) {
            // Skip duplicate first element
            if (i > 0 && arr.get(i).equals(arr.get(i - 1))) {
                continue;
            }
            for (int j = i + 1; j < n - 2; j++) {
                // Skip duplicate second element
                if (j > i + 1 && arr.get(j).equals(arr.get(j - 1))) {
                    continue;
                }
                int left = j + 1;
                int right = n - 1;

                while (left < right) {
                    long sum = (long) arr.get(i)
                            + arr.get(j)
                            + arr.get(left)
                            + arr.get(right);

                    if (sum < target) {
                        left++;
                    } else if (sum > target) {
                        right--;
                    } else {
                        ans.add(Arrays.asList(
                                arr.get(i),
                                arr.get(j),
                                arr.get(left),
                                arr.get(right)));

                        left++;
                        right--;
                        // Skip duplicate third element
                        while (left < right &&
                                arr.get(left).equals(arr.get(left - 1))) {
                            left++;
                        }
                        // Skip duplicate fourth element
                        while (left < right &&
                                arr.get(right).equals(arr.get(right + 1))) {
                            right--;
                        }
                    }
                }
            }
        }
        return ans;
    }

    // Better Solution - HashSet
    // Time Complexity: O(n^3)
    // Space Complexity: O(n)
    static List<List<Integer>> betterSol(List<Integer> arr, int target) {

        int n = arr.size();

        Set<List<Integer>> ansSet = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                Set<Integer> set = new HashSet<>();
                for (int k = j + 1; k < n; k++) {
                    long req = (long) target
                            - arr.get(i)
                            - arr.get(j)
                            - arr.get(k);

                    if (req >= Integer.MIN_VALUE &&
                            req <= Integer.MAX_VALUE &&
                            set.contains((int) req)) {

                        List<Integer> temp = Arrays.asList(
                                arr.get(i),
                                arr.get(j),
                                arr.get(k),
                                (int) req);

                        Collections.sort(temp);
                        ansSet.add(temp);
                    }
                    set.add(arr.get(k));
                }
            }
        }

        return new ArrayList<>(ansSet);
    }

    // Brute Force
    // Time Complexity: O(n^4)
    // Space Complexity: O(1)
    static List<List<Integer>> bruteSol(List<Integer> arr, int target) {

        int n = arr.size();

        Set<List<Integer>> ansSet = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    for (int l = k + 1; l < n; l++) {

                        long sum = (long) arr.get(i)
                                + arr.get(j)
                                + arr.get(k)
                                + arr.get(l);

                        if (sum == target) {
                            List<Integer> temp = Arrays.asList(
                                    arr.get(i),
                                    arr.get(j),
                                    arr.get(k),
                                    arr.get(l));

                            Collections.sort(temp);
                            ansSet.add(temp);
                        }
                    }
                }
            }
        }
        return new ArrayList<>(ansSet);
    }

    public static void main(String[] args) {

        List<Integer> arr = Arrays.asList(
                1, 0, -1, 0, -2, 2
        );

        int target = 0;

        System.out.println("Brute Force: " + bruteSol(arr, target));

        System.out.println("\nBetter: " + betterSol(arr, target));

        System.out.println("\nOptimal: " + optimalSol(arr, target));
    }
}