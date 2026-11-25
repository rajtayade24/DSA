package com.java.dsa;

public class LC2596CheckKnightTourConfiguration {

    static boolean checkValidGrid(int[][] grid) {
        int n = grid.length;

        if (grid[0][0] != 0) {
            return false;
        }

        int[][] pos = new int[n * n][2];

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                pos[grid[r][c]][0] = r;
                pos[grid[r][c]][1] = c;
            }
        }

        for (int i = 0; i < n * n - 1; i++) {
            int rowDiff = Math.abs(pos[i][0] - pos[i + 1][0]);
            int colDiff = Math.abs(pos[i][1] - pos[i + 1][1]);

            if (!((rowDiff == 2 && colDiff == 1) ||
                    (rowDiff == 1 && colDiff == 2))) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {0, 11, 16, 5, 20},
                {17, 4, 19, 10, 15},
                {12, 1, 8, 21, 6},
                {3, 18, 23, 14, 9},
                {24, 13, 2, 7, 22}
        };

//        int[][] grid = {
//                {0, 3, 6},
//                {5, 8, 1},
//                {2, 7, 4}
//        };

        System.out.println(checkValidGrid(grid));
    }
}
