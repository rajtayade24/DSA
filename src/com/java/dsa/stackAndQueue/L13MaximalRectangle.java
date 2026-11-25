package com.java.dsa.stackAndQueue;

import java.util.Stack;

public class L13MaximalRectangle {

    static int lHist(int[] heights) {
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        int maxArea = 0;

        for (int i = 0; i <= n; i++) {

            while (!st.isEmpty() && (i == n || heights[st.peek()] >= heights[i])) {

                int height = heights[st.pop()];

                int leftSmall = st.isEmpty() ? -1 : st.peek();
                int rightSmall = i;

                int width = rightSmall - leftSmall - 1;

                maxArea = Math.max(maxArea, height * width);
            }

            st.push(i);
        }

        return maxArea;
    }

    // Maximal Rectangle
    static int mostOptimal(char[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return 0;

        int n = matrix.length;
        int m = matrix[0].length;

        int[] heights = new int[m];
        int maxArea = 0;

        for (int i = 0; i < n; i++) {

            // Update histogram
            for (int j = 0; j < m; j++) {

                if (matrix[i][j] == '1')
                    heights[j]++;
                else
                    heights[j] = 0;
            }

            // Find largest rectangle in current histogram
            maxArea = Math.max(maxArea, lHist(heights));
        }

        return maxArea;
    }

    static int[][] findPreSum(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[][] psum = new int[n][m];

        for (int j = 0; j < m; j++) {   // First row
            psum[0][j] = matrix[0][j] - '0';
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '1') {
                    psum[i][j] = psum[i - 1][j] + 1;
                } else {
                    psum[i][j] = 0;
                }
            }
        }
        return psum;
    }

    static int sol(char[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return 0;

        int n = matrix.length;
        int[][] psum = findPreSum(matrix);
        int maxArea = 0;

        for (int i = 0; i < n; i++) {
            maxArea = Math.max(maxArea, lHist(psum[i]));
        }

        return maxArea;
    }

    public static void main(String[] args) {
        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };

        System.out.println("Area: " + sol(matrix));
    }
}
