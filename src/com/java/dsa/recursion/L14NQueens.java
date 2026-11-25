package com.java.dsa.recursion;

import java.util.ArrayList;
import java.util.List;

public class L14NQueens {

    // Striver Approach
    static boolean isSafe(
            int row, int col, char[][] board, int n) {

        // Check upper-left diagonal
        int r = row;
        int c = col;

        while (r >= 0 && c >= 0) {
            if (board[r][c] == 'Q') return false;
            r--;
            c--;
        }

        // Check left side
        r = row;
        c = col;
        while (c >= 0) {
            if (board[r][c] == 'Q') return false;
            c--;
        }

        // Check lower-left diagonal
        r = row;
        c = col;
        while (r < n && c >= 0) {
            if (board[r][c] == 'Q') return false;
            r++;
            c--;
        }

        return true;
    }

    static void solve(
            int col, List<List<String>> ans, char[][] board, int n) {

        // Base case
        if (col == n) {
            List<String> list = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                list.add(new String(board[i]));
            }
            ans.add(list);

            return;
        }

        // Try every row for the current column
        for (int row = 0; row < n; row++) {
            if (isSafe(row, col, board, n)) {
                // Place Queen
                board[row][col] = 'Q';

                // Move to next column
                solve(col + 1, ans, board, n);

                // Backtrack
                board[row][col] = '.';
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

        solve(0, ans, board, n);

        return ans;
    }

    public static void main(String[] args) {

        int n = 4;

        System.out.println(solveNQueens(n));
        // [[..Q., Q..., ...Q, .Q..], [.Q.., ...Q, Q..., ..Q.]]
    }
}
