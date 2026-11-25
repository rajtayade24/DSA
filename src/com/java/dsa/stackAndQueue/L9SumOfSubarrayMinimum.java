package com.java.dsa.stackAndQueue;

import java.util.Stack;

public class L9SumOfSubarrayMinimum {

    // Next Smaller Element
    static int[] findNextSmaller(int[] arr) {
        int n = arr.length;
        int[] nse = new int[n];

        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {

            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }

            nse[i] = st.isEmpty() ? n : st.peek();

            st.push(i);
        }

        return nse;
    }

    // Previous Smaller Element
    static int[] findPrevSmaller(int[] arr) {
        int n = arr.length;
        int[] pse = new int[n];

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {

            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }

            pse[i] = st.isEmpty() ? -1 : st.peek();

            st.push(i);
        }

        return pse;
    }

    static int sumOfMinimums(int[] arr) {
        int n = arr.length;

        int[] pse = findPrevSmaller(arr);
        int[] nse = findNextSmaller(arr);

        long total = 0;
        int mod = (int) 1e9 + 7;

        for (int i = 0; i < n; i++) {
            long left = i - pse[i];
            long right = nse[i] - i;

            total = (total + (left * right * arr[i]) % mod) % mod;
        }
        return (int) total;
    }

    static int bruteSol(int[] arr) {
        int n = arr.length;

        int sum = 0;
        int mod = (int) 1e9 + 7;

        for (int i = 0; i < n; i++) {
            int min = arr[i];
            for (int j = i; j < n; j++) {
                min = Math.min(min, arr[j]); // Maintain minimum of current subarray
                sum = (sum + min) % mod;      // Add minimum to answer
            }
        }
        return sum;
    }


    static int usingDynamicProgramming(int[] arr) {
        int n = arr.length;
        int mod = 1000000007;
        int[] right = new int[n + 1];
        int[] left = new int[n + 1];
        int[] sum = new int[n + 1];

        for (int i = 0; i < n; ++i) {
            right[i + 1] = arr[i];
        }

        int res = 0;
        for (int i = 1; i <= n; i++) {
            int curr = right[i];
            int j = i - 1;

            while (right[j] >= curr) {
                j = left[j];
            }

            left[i] = j;
            sum[i] = sum[j] + curr * (i - j);
            res = (res + sum[i]) % mod;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 4}; // 17
//        int[] arr = {11,81,94,43,3}; // 444

        System.out.println("Ans: " + bruteSol(arr));
        System.out.println("Ans: " + sumOfMinimums(arr));
    }
}
