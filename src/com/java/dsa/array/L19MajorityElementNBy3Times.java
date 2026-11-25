package com.java.dsa.array;

import java.util.*;

public class L19MajorityElementNBy3Times {

    // Optimal - Moore's Voting Algorithm - O(n)
    static List<Integer> optimalSol(int[] nums) {
        int n = nums.length;

        int el1 = 0, el2 = 0;
        int cnt1 = 0, cnt2 = 0;

        // Step 1: Find two candidates
        for (int num : nums) {
            if (cnt1 == 0 && num != el2) {
                el1 = num;
                cnt1 = 1;
            } else if (cnt2 == 0 && num != el1) {
                el2 = num;
                cnt2 = 1;
            } else if (num == el1) {
                cnt1++;
            } else if (num == el2) {
                cnt2++;
            } else {
                cnt1--;
                cnt2--;
            }
        }

        // Step 2: Verify candidates
        cnt1 = 0;
        cnt2 = 0;

        for (int num : nums) {
            if (num == el1) cnt1++;
            if (num == el2) cnt2++;
        }

        List<Integer> ans = new ArrayList<>();

        if (cnt1 > n / 3) ans.add(el1);
        if (cnt2 > n / 3) ans.add(el2);

        return ans;
    }

    // Better - HashMap - O(n)
    static List<Integer> betterSol(int[] nums) {

        int n = nums.length;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer> ans = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > n / 3) {
                ans.add(entry.getKey());
            }
        }

        return ans;
    }

    // Brute Force - O(n²)
    static List<Integer> bruteSol(int[] nums) {

        int n = nums.length;
        List<Integer> ans = new ArrayList<>();

        for (int num : nums) {
            // Avoid duplicates
            if (!ans.isEmpty() && ans.contains(num)) {
                continue;
            }

            int count = 0;
            for (int el : nums) {
                if (el == num) {
                    count++;
                }
            }

            if (count > n / 3)
                ans.add(num);
            if (ans.size() == 2)
                break;
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] nums = {1, 1, 1, 1, 3, 3, 2, 2, 2};

        // List<Integer> ans = bruteSol(nums);
        // List<Integer> ans = betterSol(nums);
        List<Integer> ans = optimalSol(nums);

        System.out.println("Majority Elements: " + ans);
    }
}