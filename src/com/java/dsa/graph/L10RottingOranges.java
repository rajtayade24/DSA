package com.java.dsa.graph;

import java.util.LinkedList;
import java.util.Queue;

public class L10RottingOranges {

    static class Pair {
        int first;
        int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    static int selfTry(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;

        Queue<Pair> queue = new LinkedList<>();
        int fresh = 0; // counts how many fresh oranges (1) remain in the grid.

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new Pair(i, j));
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        int[][] directions = {
                {-1, 0}, // up
                {1, 0},  // down
                {0, -1}, // left
                {0, 1}   // right
        };

        int time = 0;
        while (!queue.isEmpty() && fresh > 0) {
            int size = queue.size();

            for (int q = 0; q < size; q++) {
                Pair pair = queue.poll();

                for (int i = 0; i < 4; i++) {
                    int nrow = pair.first + directions[i][0];
                    int ncol = pair.second + directions[i][1];

                    if (nrow >= 0 && nrow < m
                            && ncol >= 0 && ncol < n
                            && grid[nrow][ncol] == 1) {

                        grid[nrow][ncol] = 2;
                        fresh--;
                        queue.add(new Pair(nrow, ncol));
                    }
                }
            }

            time++;
        }

        return fresh == 0 ? time : -1;
    }


    public static void main(String[] args) {
        int[][] grid = {
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        };

        System.out.println(selfTry(grid));
    }
}
