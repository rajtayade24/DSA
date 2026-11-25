package com.java.dsa.array;

import java.util.*;

public class L20ThreeSum {

    public static List<List<Integer>> optimalSol(List<Integer> arr) {
        int n = arr.size();

        Collections.sort(arr);

        List<List<Integer>> ansArray = new ArrayList<>();

        for (int i = 0; i < n - 2; i++) {

            if (i > 0 && arr.get(i) == arr.get(i - 1))
                continue;

            int left = i + 1, right = n - 1;

            while (left < right) {
                int sum = arr.get(i) + arr.get(left) + arr.get(right);
                if (sum < 0) {
                    left++;
                } else if (sum > 0) {
                    right--;
                } else {
                    ansArray.add(Arrays.asList(arr.get(i), arr.get(left), arr.get(right)));
                    left++;
                    right--;

                    while (left < right && arr.get(left) == arr.get(left - 1))
                        left++;
                    while (left < right && arr.get(right) == arr.get(right + 1))
                        right--;
                }
            }
        }
        return new ArrayList<>(ansArray);
    }

    public static List<List<Integer>> betterSol(List<Integer> arr) {
        int n = arr.size();

        Set<List<Integer>> ansSet = new HashSet<>();

        for (int i = 0; i < n; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = i + 1; j < n; j++) {
                int req = -(arr.get(i) + arr.get(j));
                if (set.contains(req)) {
                    List<Integer> temp = Arrays.asList(arr.get(i), arr.get(j), req);
                    Collections.sort(temp);
                    ansSet.add(temp);
                }
                set.add(arr.get(j));
            }
        }
        return new ArrayList<>(ansSet);
    }

    public static List<List<Integer>> bruteSol(List<Integer> arr) {
        int n = arr.size();

        Set<List<Integer>> ansSet = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (arr.get(i) + arr.get(j) + arr.get(k) == 0) {
                        List<Integer> temp = Arrays.asList(arr.get(i), arr.get(j), arr.get(k));
                        // Sort the triplet so that [-1, 0, 1], and [1, 0, -1] are treated as same
                        Collections.sort(temp);
                        ansSet.add(temp);
                    }
                }
            }
        }

        return new ArrayList<>(ansSet);
    }

    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(-1, 0, 1, 2, -1, -4);
        System.out.println(bruteSol(arr));
        System.out.println(betterSol(arr));
        System.out.println(optimalSol(arr));
    }
}