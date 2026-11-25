package com.java.dsa.stackAndQueue;

import java.util.Stack;

public class L6NextGreaterElement2 {

    static int[] usingMonotonicStack(int[] nums) {

        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[n];

        for (int i = 2 * n - 1; i >= 0; i--) {
            int next = i % n;

            while (!st.isEmpty() && st.peek() <= nums[next]) {
                st.pop();
            }

            if (i < n) {
                if (st.isEmpty()) ans[i] = -1;
                else ans[i] = st.peek();
            }

            st.push(nums[next]);
        }

        return ans;
    }

    static int[] selfTry(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {

            ans[i] = -1;

            for (int j = 1; j < n; j++) {

                int next = (i + j) % n;

                if (nums[next] > nums[i]) {
                    ans[i] = nums[next];
                    break;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {2, 10, 12, 1, 11};

        int[] ans = usingMonotonicStack(nums);

        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}
