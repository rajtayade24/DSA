package com.java.dsa;

public class LC2965FindMissingAndRepeatedValues {

    static int[] selfTry(int[][] grid) {
        int n = grid.length;
        int size = n * n;

        long actualSum = 0;
        long actualSquareSum = 0;

        // Calculate actual sum and actual sum of squares
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                int value = grid[i][j];

                actualSum += value;
                actualSquareSum += (long) value * value;
            }
        }

        // Expected sum: 1 + 2 + ... + n²
        long expectedSum = (long) size * (size + 1) / 2;

        // Expected sum of squares:
        // 1² + 2² + ... + (n²)²
        long expectedSquareSum =
                (long) size * (size + 1) * (2L * size + 1) / 6;

        // actualSum - expectedSum = repeated - missing
        long diff = actualSum - expectedSum;

        // actualSquareSum - expectedSquareSum
        // = repeated² - missing²
        long squareDiff = actualSquareSum - expectedSquareSum;

        // repeated² - missing²
        // = (repeated - missing)(repeated + missing)
        long sum = squareDiff / diff;

        // repeated - missing = diff
        // repeated + missing = sum
        long repeated = (diff + sum) / 2;

        long missing = repeated - diff;

        return new int[]{(int) repeated, (int) missing};
    }
}
