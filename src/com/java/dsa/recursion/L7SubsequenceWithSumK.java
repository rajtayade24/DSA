package com.java.dsa.recursion;

import java.util.ArrayList;
import java.util.List;

public class L7SubsequenceWithSumK {

    static int sum(List<Integer> list) {
        int result = 0;
        for (Integer integer : list) {
            result += integer;
        }
        return result;
    }

    static void print(int index, List<Integer> list, int[] nums, int n, int target) {

        if (index >= n) {
            if (sum(list) == target) {
                System.out.println(list);
            }
            return;
        }

        list.add(nums[index]);

        print(index + 1, list, nums, n, target);

        list.removeLast();

        print(index + 1, list, nums, n, target);
    }


    // Optimal solution
    static void printF(int index, List<Integer> list, int sum, int[] nums, int n, int target) {

        if (index >= n) {
            if (sum == target) {
                System.out.println(list);
            }
            return;
        }

        // Take
        list.add(nums[index]);

        int newSUm = sum + nums[index];
        printF(index + 1, list, newSUm, nums, n, target);

        // Backtrack
        list.removeLast();

        // Don't take
        printF(index + 1, list, sum, nums, n, target);
    }

    // Print one answer
    static boolean printF1Ans(int index, List<Integer> list, int sum, int[] nums, int n, int target) {

        if (index >= n) {
            if (sum == target) {
                System.out.println(list);
                return true;
            }
            return false;
        }

        // Take
        list.add(nums[index]);

        int newSUm = sum + nums[index];
        if (printF1Ans(index + 1, list, newSUm, nums, n, target))
            return true;

        // Backtrack
        list.removeLast();

        // Don't take
        if (printF1Ans(index + 1, list, sum, nums, n, target))
            return true;

        return false;
    }

    // brute force solution
    static int subsequenceCount(int index, List<Integer> list, int sum, int count, int[] nums, int n, int target) {

        if (index >= n) {
            if (sum == target) {
                count++;
            }
            return count;
        }

        // Take
        list.add(nums[index]);

        int newSum = sum + nums[index];
        count = subsequenceCount(index + 1, list, newSum, count, nums, n, target);

        // Backtrack
        list.removeLast();

        // Don't take
        count = subsequenceCount(index + 1, list, sum, count, nums, n, target);

        return count;
    }

    // Optimal solution
    static int countSubsequences(int index, int sum, int[] nums, int n, int target) {

        if (index >= n) {
            return sum == target ? 1 : 0;
        }

        // Take
        int take = countSubsequences(
                index + 1,
                sum + nums[index],
                nums,
                n,
                target
        );

        // Don't take
        int notTake = countSubsequences(
                index + 1,
                sum,
                nums,
                n,
                target
        );

        return take + notTake;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1};

        List<Integer> list = new ArrayList<>();

        System.out.println("Brute force solution");
        print(0, list, nums, nums.length, 2);

        System.out.println("Optimal solution");
        printF(0, list, 0, nums, nums.length, 2);

        System.out.println("Print only one answer with sum k");
        printF1Ans(0, list, 0, nums, nums.length, 2);

        System.out.println("Count Subsequence: "
                + subsequenceCount(0, list, 0, 0, nums, nums.length, 2));

        System.out.println("Count Subsequence: "
                + countSubsequences(0, 0, nums, nums.length, 2));
    }
}