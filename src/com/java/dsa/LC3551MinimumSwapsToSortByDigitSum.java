package com.java.dsa;

import java.util.Arrays;

public class LC3551MinimumSwapsToSortByDigitSum {

    public int minSwaps(int[] nums) {
        int n = nums.length;

        // {number, digitSum, originalIndex}
        int[][] arr = new int[n][3];

        for (int i = 0; i < n; i++) {
            int num = nums[i];
            int sum = 0;

            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }

            arr[i][0] = nums[i];
            arr[i][1] = sum;
            arr[i][2] = i;
        }

        // Sort by digit sum, then by number
        Arrays.sort(arr, (a, b) -> {
            if (a[1] != b[1]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });

        boolean[] visited = new boolean[n];
        int swaps = 0;

        // Count cycles in the permutation
        for (int i = 0; i < n; i++) {
            if (visited[i] || arr[i][2] == i) {
                continue;
            }

            int j = i;
            int cycleSize = 0;

            while (!visited[j]) {
                visited[j] = true;
                j = arr[j][2];
                cycleSize++;
            }

            swaps += cycleSize - 1;
        }

        return swaps;
    }

    public static void main(String[] args) {

    }
}
