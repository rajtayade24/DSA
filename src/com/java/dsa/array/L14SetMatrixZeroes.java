package com.java.dsa.array;

import java.util.ArrayList;
import java.util.List;

public class L14SetMatrixZeroes {

    // Optimal (O(1) Space)
    static void optimalSol(int[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        int col0 = 1;
        // Step 1: Mark rows and columns
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    if (j != 0) {
                        matrix[0][j] = 0;
                    } else {
                        col0 = 0;
                    }
                }
            }
        }

        // Step 2: Fill inner matrix
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] != 0) {
                    if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                        matrix[i][j] = 0;
                    }
                }
            }
        }

        // Step 3: First row
        if (matrix[0][0] == 0) {
            for (int j = 0; j < cols; j++) {
                matrix[0][j] = 0;
            }
        }

        // Step 4: First column
        if (col0 == 0) {
            for (int i = 0; i < rows; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    // Better (List)
    static void betterSol(int[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        List<Integer> row = new ArrayList<>();
        List<Integer> col = new ArrayList<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    row.add(i);
                    col.add(j);
                }
            }
        }

        for (int r : row) {
            for (int j = 0; j < cols; j++) {
                if (matrix[r][j] != 0) {
                    matrix[r][j] = -1;
                }
            }
        }

        for (int c : col) {
            for (int i = 0; i < rows; i++) {
                if (matrix[i][c] != 0) {
                    matrix[i][c] = -1;
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (matrix[i][j] == -1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    // Better (Boolean Arrays)
    static void betterSolution(int[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        boolean[] row = new boolean[rows];
        boolean[] col = new boolean[cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (row[i] || col[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    // Brute Force
    static void bruteSol(int[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    markRow(matrix, i);
                    markCol(matrix, j);
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (matrix[i][j] == -1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    static void markRow(int[][] matrix, int row) {

        int cols = matrix[0].length;
        for (int j = 0; j < cols; j++) {
            if (matrix[row][j] != 0)
                matrix[row][j] = -1;
        }
    }

    static void markCol(int[][] matrix, int col) {

        int rows = matrix.length;
        for (int i = 0; i < rows; i++) {
            if (matrix[i][col] != 0)
                matrix[i][col] = -1;
        }
    }

    // Print Matrix
    static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        int[][] matrix = {
                {1, 1, 1, 1},
                {1, 0, 0, 1},
                {1, 1, 0, 1},
                {1, 1, 1, 1}
        };

        optimalSol(matrix);

        printMatrix(matrix);
    }
}