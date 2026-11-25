package com.java.dsa.stackAndQueue;

import java.util.Stack;

import static com.java.dsa.stackAndQueue.L9SumOfSubarrayMinimum.findNextSmaller;
import static com.java.dsa.stackAndQueue.L9SumOfSubarrayMinimum.findPrevSmaller;

public class L12LargestRectangleInHistogram {

    static int optimalSol(int[] heights) {
        int n = heights.length;

        Stack<Integer> st = new Stack<>();
        int maxArea = 0;

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty()
                    && heights[st.peek()] > heights[i]) {
                int element = st.peek();
                st.pop();
                int nse = i, pse = st.isEmpty() ? -1 : st.peek();

                maxArea = Math.max(heights[element] * (nse - pse - 1), maxArea);
            }
            st.push(i);
        }
        while (!st.isEmpty()) {
            int element = st.peek();
            st.pop();
            int nse = n, pse = st.isEmpty() ? -1 : st.peek();

            maxArea = Math.max(heights[element] * (nse - pse - 1), maxArea);
        }

        return maxArea;
    }

    static int betterSol(int[] heights) {
        int n = heights.length;

        int[] pse = findPrevSmaller(heights);
        int[] nse = findNextSmaller(heights);
        int maxArea = 0;

        for (int i = 0; i < n; i++) {
            int area = heights[i] * (nse[i] - pse[i] - 1);
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }

    static int bruteSol(int[] heights) {
        int n = heights.length;
        int maxArea = 0;

        for (int i = 0; i < n; i++) {
            int minHeight = Integer.MAX_VALUE;

            for (int j = i; j < n; j++) {
                // Update minimum height in the current range [i...j]
                minHeight = Math.min(minHeight, heights[j]);

                // Width of current rectangle
                int width = j - i + 1;

                // Calculate area
                int area = minHeight * width;

                // Update answer
                maxArea = Math.max(maxArea, area);
            }
        }

        return maxArea;
    }

    /// Wrong in some cases
//    static int selfTry(int[] heights) {
//        int n = heights.length;
//
//        int ans = 0;
//        for (int i = 0; i < n; i++) {
//            int area = heights[i];
//            for (int j = i + 1; j < n; j++) {
//                if (heights[j] < heights[i])
//                    break;
//
//                area += heights[i];
//                ans = Math.max(ans, area);
//            }
//        }
//        return ans;
//    }
    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3}; // 10
//        int[] heights = {2, 4}; // 4

        System.out.println("Ans: " + bruteSol(heights));
        System.out.println("Ans: " + betterSol(heights));
        System.out.println("Ans: " + optimalSol(heights));
    }
}