package com.java.dsa;

public class LC79WordSearchImportant {

    static boolean selfTry(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (dfs(0, i, j, board, word)) {
                    return true;
                }
            }
        }

        return false;
    }

    static boolean dfs(int index, int row, int col, char[][] board, String word) {

        // All characters matched
        if (index == word.length()) {
            return true;
        }

        // Out of bounds
        if (row < 0 || row >= board.length
                || col < 0 || col >= board[0].length
                || board[row][col] != word.charAt(index)) { // Current character doesn't match
            return false;
        }

        // Mark current cell as visited
        char original = board[row][col];
        board[row][col] = '#';

        // Explore 4 directions
        boolean found =
                dfs(index + 1, row + 1, col, board, word) ||  // Down
                        dfs(index + 1, row - 1, col, board, word) ||  // Up
                        dfs(index + 1, row, col + 1, board, word) ||  // Right
                        dfs(index + 1, row, col - 1, board, word);    // Left

        // Backtrack
        board[row][col] = original;

        return found;
    }

    public static void main(String[] args) {
        // Example 1
        char[][] board1 = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };

        String word1 = "ABCCED";

        System.out.println("Example 1: " + selfTry(board1, word1));


        // Example 2
        char[][] board2 = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };

        String word2 = "SEE";

        System.out.println("Example 2: " + selfTry(board2, word2));


        // Example 3
        char[][] board3 = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };

        String word3 = "ABCB";

        System.out.println("Example 3: " + selfTry(board3, word3));
    }
}
