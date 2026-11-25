package com.java.dsa.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class L13DistanceOfNearestCellHavingZero {

    static class Pair {
        int first;
        int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    static int[][] selfTry(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int[][] distance = new int[m][n];
        Queue<Pair> queue = new LinkedList<>();

        // Step 1: Add all zeros to the queue
        // Mark all ones as unvisited (-1)
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (mat[i][j] == 0) {
                    distance[i][j] = 0;
                    queue.offer(new Pair(i, j));
                } else {
                    distance[i][j] = -1;
                }
            }
        }

        int[][] directions = {
                {-1, 0},  // Up
                {1, 0},   // Down
                {0, -1},  // Left
                {0, 1}    // Right
        };

        // Step 2: Perform multi-source BFS
        while (!queue.isEmpty()) {

            Pair pair = queue.poll();

            int row = pair.first;
            int col = pair.second;

            for (int i = 0; i < 4; i++) {

                int nrow = row + directions[i][0];
                int ncol = col + directions[i][1];

                // Check boundaries and whether unvisited
                if (nrow >= 0 && nrow < m
                        && ncol >= 0 && ncol < n
                        && distance[nrow][ncol] == -1) {

                    distance[nrow][ncol] =
                            distance[row][col] + 1;

                    queue.add(new Pair(nrow, ncol));
                }
            }
        }

        return distance;
    }

    public static void main(String[] args) {

        int[][] mat = {
                {0, 0, 0},
                {0, 1, 0},
                {1, 1, 1}
        };

        int[][] result = selfTry(mat);

        for (int[] row : result) {
            System.out.println(Arrays.toString(row));
        }
    }
}