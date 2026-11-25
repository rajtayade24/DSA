package com.java.dsa;

public class LC74SearchA2DMatrix {

    static boolean selfTry(int[][] matrix, int target) {
        int top = 0, bottom = matrix.length - 1;

        // Find the possible row
        while (top <= bottom) {
            int mid = (top + bottom) / 2;

            if (target >= matrix[mid][0] &&
                    target <= matrix[mid][matrix[0].length - 1]) {

                // We found the possible row
                int left = 0;
                int right = matrix[0].length - 1;

                // Binary search in that row
                while (left <= right) {

                    int midCol = (left + right) / 2;

                    if (matrix[mid][midCol] == target) {
                        return true;
                    } else if (matrix[mid][midCol] < target) {
                        left = midCol + 1;
                    } else {
                        right = midCol - 1;
                    }
                }

                return false;
            } else if (matrix[mid][0] < target) {
                top = mid + 1;
            } else {
                bottom = mid - 1;
            }

        }
        return false;
    }


    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };

        int target = 16;

        System.out.println(selfTry(matrix, target));
    }
}
