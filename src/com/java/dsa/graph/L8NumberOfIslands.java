package com.java.dsa.graph;

import java.util.LinkedList;
import java.util.Queue;

public class L8NumberOfIslands {

    static void dfs(int row, int col, char[][] grid) {
        if (row < 0 || row >= grid.length ||
                col < 0 || col >= grid[0].length ||
                grid[row][col] == '0') {
            return;
        }

        grid[row][col] = '0';

        dfs(row - 1, col, grid); // up
        dfs(row + 1, col, grid); // down
        dfs(row, col - 1, grid); // left
        dfs(row, col + 1, grid); // right
    }

    /// Optimal
    static int selfTry(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(i, j, grid);
                }
            }
        }

        return count;
    }

    static class Pair {
        int first;
        int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    static void bfs(int row, int col, boolean[][] visited, char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<Pair> queue = new LinkedList<>();

        visited[row][col] = true;
        queue.add(new Pair(row, col));

        int[][] directions = {
                {-1, 0}, // up
                {1, 0},  // down
                {0, -1}, // left
                {0, 1}   // right
        };

        while (!queue.isEmpty()) {

            int first = queue.peek().first;
            int second = queue.peek().second;

            queue.remove();

            for (int i = 0; i < 4; i++) {

                int nrow = first + directions[i][0];
                int ncol = second + directions[i][1];

                if (nrow >= 0 && nrow < m
                        && ncol >= 0 && ncol < n
                        && grid[nrow][ncol] == '1'
                        && !visited[nrow][ncol]) {

                    visited[nrow][ncol] = true;
                    queue.add(new Pair(nrow, ncol));
                }
            }
        }
    }

    static int usingStriverBfs(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    count++;
                    bfs(i, j, visited, grid);
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {

        char[][] grid = {
                {'1', '1', '0', '0', '1'},
                {'1', '0', '0', '0', '1'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '0', '1'}
        };

        System.out.println(selfTry(grid));
    }
}
