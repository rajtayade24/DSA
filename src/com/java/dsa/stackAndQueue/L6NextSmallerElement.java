package com.java.dsa.stackAndQueue;

import java.util.Stack;

public class L6NextSmallerElement {

    static int[] usingMonotonicStack(int[] nums) {
        int n = nums.length;

        Stack<Integer> st = new Stack<>();
        int[] ans = new int[n];

        for (int i = n - 1; i >= 0; i--) {

            while (!st.isEmpty() && nums[i] <= st.peek()) {
                st.pop();
            }

            ans[i] = st.isEmpty() ? -1 : st.peek();

            st.push(nums[i]);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {4, 8, 5, 2, 25}; // 2, 5, 2, -1, -1

        int[] ans = usingMonotonicStack(nums);

        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}
