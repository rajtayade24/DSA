package com.java.dsa.recursion;

import java.util.Arrays;

public class L15Sudoku {

    static boolean isValid(char[][] board, int row, int col, char ch) {

        for (int i = 0; i < 9; i++) {
            if (board[i][col] == ch)
                return false;

            if (board[row][i] == ch)
                return false;

            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == ch)
                return false;
        }
        return true;
    }

    static boolean solve(char[][] board, int n) {

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {

                if (board[row][col] == '.') {

                    for (char ch = '1'; ch <= '9'; ch++) {
                        if (isValid(board, row, col, ch)) {
                            board[row][col] = ch;

                            if (solve(board, n)) {
                                return true;
                            } else {
                                board[row][col] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {

        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        solve(board, board.length);

        for (char[] row : board) {
            System.out.println(Arrays.toString(row));
        }
    }
}
