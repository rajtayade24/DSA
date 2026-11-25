package com.java.dsa.array;

import java.util.Arrays;

public class L15RotateMatrix {

    // Optimal - O(1) Extra Space
    static void optimalSol(int[][] mat) {

        int n = mat.length;

        // Step 1: Transpose
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }

        // Step 2: Reverse every row
        for (int i = 0; i < n; i++) {

            int left = 0;
            int right = n - 1;

            while (left < right) {
                int temp = mat[i][left];
                mat[i][left] = mat[i][right];
                mat[i][right] = temp;
                left++;
                right--;
            }
        }
    }

    // Brute Force - O(n²) Space
    static void bruteSol(int[][] mat) {

        int n = mat.length;

        int[][] copy = new int[n][n];

        // Copy mat
        for (int i = 0; i < n; i++) {
            copy[i] = Arrays.copyOf(mat[i], n);
        }

        // Rotate
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = copy[n - j - 1][i];
            }
        }
    }

    static void printMatrix(int[][] mat) {

        for (int[] row : mat) {

            for (int num : row) {
                System.out.print(num + "\t");
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {

        int[][] mat = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        System.out.println("Original mat:");
        printMatrix(mat);

        optimalSol(mat);

        System.out.println("\nRotated mat (90° Clockwise):");
        printMatrix(mat);
    }
}