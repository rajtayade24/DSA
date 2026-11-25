package com.java.dsa.recursion;

import java.util.ArrayList;
import java.util.List;

public class L14NQueensOptimal {

    private static void solve(
            int col, List<List<String>> ans,
            boolean[] leftRow, boolean[] lowerDiagonal, boolean[] upperDiagonal,
            char[][] board, int n) {

        // Base case
        if (col == n) {
            List<String> list = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                list.add(new String(board[i]));
            }
            ans.add(list);

            return;
        }

        for (int row = 0; row < n; row++) {
            if (!leftRow[row]
                    && !lowerDiagonal[row + col]
                    && !upperDiagonal[n + (col - row)]) {

                // Place Queen
                board[row][col] = 'Q';
                leftRow[row] = true;
                lowerDiagonal[row + col] = true;
                upperDiagonal[n + (col - row)] = true;

                // Move to next column
                solve(col + 1, ans, leftRow, lowerDiagonal, upperDiagonal, board, n);

                // Backtrack
                board[row][col] = '.';
                leftRow[row] = false;
                lowerDiagonal[row + col] = false;
                upperDiagonal[n + (col - row)] = false;
            }
        }
    }

    static List<List<String>> solveNQueens(int n) {

        List<List<String>> ans = new ArrayList<>();

        // Create empty board
        char[][] board = new char[n][n];

        // Fill board with '.'
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        boolean[] leftRow = new boolean[n];
        boolean[] lowerDiagonal = new boolean[2 * n - 1];
        boolean[] upperDiagonal = new boolean[2 * n - 1];

        solve(0, ans, leftRow, lowerDiagonal, upperDiagonal, board, n);

        return ans;
    }

    public static void main(String[] args) {

        int n = 4;

        System.out.println(solveNQueens(n));
        // [[..Q., Q..., ...Q, .Q..], [.Q.., ...Q, Q..., ..Q.]]
    }
}
