package com.java.dsa.binarySearch;

public class LSearch2DMatrix {

    static boolean striver(int[][] mat, int target) {
        int n = mat.length, m = mat[0].length;

        int low = 0, high = n * m - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            int row = mid / m;
            int col = mid % m;

            if (mat[row][col] == target)
                return true;
            else if (mat[row][col] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return false;
    }

    static boolean selfTry(int[][] mat, int target) {
        int top = 0, bottom = mat.length - 1;

        // Find the possible row
        while (top <= bottom) {
            int mid = (top + bottom) / 2;

            if (target >= mat[mid][0] &&
                    target <= mat[mid][mat[0].length - 1]) {

                // We found the possible row
                int left = 0;
                int right = mat[0].length - 1;

                // Binary search in that row
                while (left <= right) {

                    int midCol = (left + right) / 2;

                    if (mat[mid][midCol] == target) {
                        return true;
                    } else if (mat[mid][midCol] < target) {
                        left = midCol + 1;
                    } else {
                        right = midCol - 1;
                    }
                }

                return false;
            } else if (mat[mid][0] < target) {
                top = mid + 1;
            } else {
                bottom = mid - 1;
            }

        }
        return false;
    }

    public static void main(String[] args) {
        int[][] mat = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };

        int target = 3;

        System.out.println(selfTry(mat, target));
        System.out.println(striver(mat, target));
    }
}
