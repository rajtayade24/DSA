package com.java.dsa.binarySearch;

public class LFindPeakElementIIDoNotUnderstand {

    public int[] findPeakGrid(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            int m = mat.length - 1; // row
            int n = mat[i].length - 1; //col
            if (m == 0) {
                if (mat[0][0] > mat[0][1]) {
                    return new int[]{0, 0};
                }
                if (mat[0][n] > mat[0][n - 1]) {
                    return new int[]{0, n};
                }
                int left = 1;
                int right = n - 1;
                while (left <= right) {
                    int mid = left + (right - left) / 2;
                    if (mat[0][mid] > mat[0][mid - 1] && mat[0][mid] > mat[0][mid + 1]) {
                        return new int[]{0, mid};
                    } else if (mat[0][mid] > mat[0][mid - 1]) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
            }
            if (n == 0) {
                if (mat[0][0] > mat[1][0]) {
                    return new int[]{0, 0};
                }
                if (mat[m][0] > mat[m - 1][0]) {
                    return new int[]{m, 0};
                }
                int left = 1;
                int right = m - 1;
                while (left <= right) {
                    int mid = left + (right - left) / 2;
                    if (mat[mid][0] > mat[mid - 1][0] && mat[mid][0] > mat[mid + 1][0]) {
                        return new int[]{mid, 0};
                    } else if (mat[mid][0] > mat[mid - 1][0]) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
            }
            if (mat[0][0] > mat[0][1] && mat[0][0] > mat[1][0]) {
                return new int[]{0, 0};
            }
            if (mat[0][n] > mat[0][n - 1] && mat[0][n] > mat[1][n]) {
                return new int[]{0, n};
            }
            if (mat[m][n] > mat[m][n - 1] && mat[m][n] > mat[m - 1][n]) {
                return new int[]{m, n};
            }
            if (mat[m][0] > mat[m - 1][0] && mat[m][0] > mat[m][1]) {
                return new int[]{m, 0};
            }
            if (i >= 1 && i <= m - 1) {
                if (mat[i][0] > mat[i - 1][0] && mat[i][0] > mat[i + 1][0] && mat[i][0] > mat[i][1]) {
                    return new int[]{i, 0};
                }
            }
            if (i >= 1 && i <= m - 1) {
                if (mat[i][n] > mat[i - 1][n] && mat[i][n] > mat[i + 1][n] && mat[i][n] > mat[i][n - 1]) {
                    return new int[]{i, n};
                }
            }
            for (int j = i + 1; j <= n - 1; j++) {
                if (mat[0][j] > mat[0][j - 1] && mat[0][j] > mat[0][j + 1] && mat[0][j] > mat[1][j]) {
                    return new int[]{0, j};
                }
                if (mat[m][j] > mat[m][j - 1] && mat[m][j] > mat[m][j + 1] && mat[m][j] > mat[m - 1][j]) {
                    return new int[]{m, j};
                }
            }
            int left = 1;
            int right = n - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (i >= 1 && i <= m - 1 && mat[i][mid] > mat[i][mid - 1] && mat[i][mid] > mat[i][mid + 1]
                        && mat[i][mid] > mat[i - 1][mid] && mat[i][mid] > mat[i + 1][mid]) {
                    return new int[]{i, mid};
                } else if (mat[i][mid] > mat[i][mid - 1]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return new int[]{0, 0};
    }

    boolean isPeek(int i, int j, int[][] mat) {
        return (i - 1 < 0 || mat[i - 1][j] <= mat[i][j])
                && (j - 1 < 0 || mat[i][j - 1] <= mat[i][j])
                && (i + 1 >= mat.length || mat[i + 1][j] <= mat[i][j])
                && (j + 1 >= mat[0].length || mat[i][j + 1] <= mat[i][j]);
    }

    public int[] selfTry(int[][] mat) {
        int n = mat.length, m = mat[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (isPeek(i, j, mat)) {
                    return new int[] { i, j };
                }
            }
        }
        return new int[] { -1, -1 };
    }
}
