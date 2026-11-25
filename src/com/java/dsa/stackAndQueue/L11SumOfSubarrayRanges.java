package com.java.dsa.stackAndQueue;

import java.util.Stack;

import static com.java.dsa.stackAndQueue.L9SumOfSubarrayMinimum.sumOfMinimums;

public class L11SumOfSubarrayRanges {

    // Next Greater Element
    static private int[] nextGreater(int[] arr) {
        int n = arr.length;
        int[] nse = new int[n];

        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {

            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
                st.pop();
            }

            nse[i] = st.isEmpty() ? n : st.peek();

            st.push(i);
        }

        return nse;
    }

    // Previous Greater Element
    static private int[] previousGreater(int[] arr) {
        int n = arr.length;
        int[] pse = new int[n];

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {

            while (!st.isEmpty() && arr[st.peek()] <= arr[i]) {
                st.pop();
            }

            pse[i] = st.isEmpty() ? -1 : st.peek();

            st.push(i);
        }

        return pse;
    }

    static long sumOfMaximums(int[] arr){
        int n = arr.length;

        int[] pse = previousGreater(arr);
        int[] nse = nextGreater(arr);

        long total = 0;
        int mod = (int) 1e9 + 7;

        for (int i = 0; i < n; i++) {
            long left = i - pse[i];
            long right = nse[i] - i;

            total = (total + (left * right * arr[i]) % mod) % mod;
        }
        return (int) total;
    }

    static long optimalSol(int[] arr) {
        return sumOfMaximums(arr) - sumOfMinimums(arr);
    }

    static long bruteSol(int[] arr) {
        int n = arr.length;
        long ans = 0;

        for (int i = 0; i < n; i++) {
            int min = arr[i];
            int max = arr[i];

            for (int j = i + 1; j < n; j++) {
                min = Math.min(min, arr[j]);
                max = Math.max(max, arr[j]);

                ans += max - min;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {4, -2, -3, 4, 1};

        System.out.println("Ans: " + bruteSol(nums));
        System.out.println("Ans: " + optimalSol(nums));
    }
}
