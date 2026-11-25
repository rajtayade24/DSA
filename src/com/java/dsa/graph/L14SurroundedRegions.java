package com.java.dsa.graph;

import java.util.Arrays;

public class L14SurroundedRegions {

    static void dfs(int i, int j, char[][] board, boolean[][] visited) {
        if (i < 0 || i >= board.length
                || j < 0 || j >= board[0].length
                || board[i][j] == 'X'
                || visited[i][j]) {

            return;
        }

        visited[i][j] = true;

        dfs(i - 1, j, board, visited); // up
        dfs(i + 1, j, board, visited); // dawn
        dfs(i, j - 1, board, visited); // left
        dfs(i, j + 1, board, visited); // right
    }

    static void selfTry(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        boolean[][] visited = new boolean[m][n];

        // First row and last row
        for (int j = 0; j < n; j++) {

            // first row
            if (board[0][j] == 'O') {
                dfs(0, j, board, visited);
            }

            // last row
            if (board[m - 1][j] == 'O') {
                dfs(m - 1, j, board, visited);
            }
        }

        // First column and last column
        for (int i = 0; i < m; i++) {
            // first col
            if (board[i][0] == 'O') {
                dfs(i, 0, board, visited);
            }

            // last col
            if (board[i][n - 1] == 'O') {
                dfs(i, n - 1, board, visited);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public static void main(String[] args) {
        char[][] board = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };

        for (char[] row : board) {
            System.out.println(Arrays.toString(row));
        }

        selfTry(board);

        System.out.println();
        for (char[] row : board) {
            System.out.println(Arrays.toString(row));
        }
    }
}
