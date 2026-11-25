package com.java.dsa.recursion;

import java.util.ArrayList;
import java.util.List;

public class L10SubsetSum {

    static List<Integer> subsetSum(int index, int sum, List<Integer> ans, int[] arr) {
        if (index == arr.length) {
            ans.add(sum);
            return ans;
        }

        // Pick
        int newSum = sum + arr[index];
        subsetSum(index + 1, newSum, ans, arr);

        subsetSum(index+1, sum, ans, arr);

        return ans;
    }

    static List<Integer> selfTry(int index, int sum, List<Integer> ans, int[] arr) {
        return subsetSum(index, sum, ans, arr);
    }

    public static void main(String[] args) {
        int[] arr = {5, 1, 2};

        List<Integer> ans = new ArrayList<>();

        System.out.println(selfTry(0, 0, ans, arr));
    }
}
