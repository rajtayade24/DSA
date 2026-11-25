package com.java.dsa.recursion;

import java.util.ArrayList;
import java.util.List;

public class L6PrintAllSubsequences {

    static void print(int index, List<Integer> list, int[] nums, int n) {
        if (index >= n) {
            System.out.println(list);
            return;
        }

        print(index + 1, list, nums, n);

        list.add(nums[index]);

        print(index + 1, list, nums, n);

        list.removeLast();
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 2};

        List<Integer> list = new ArrayList<>();

        print(0, list, nums, nums.length);
    }
}
