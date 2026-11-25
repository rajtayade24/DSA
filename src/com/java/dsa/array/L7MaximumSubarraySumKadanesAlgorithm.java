package com.java.dsa.array;

import java.util.ArrayList;
import java.util.List;

public class L7MaximumSubarraySumKadanesAlgorithm {

    // Brute Force Solution - O(n^3)
    static int bruteSol(int[] arr) {

        int n = arr.length;
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {

            for (int j = i; j < n; j++) {

                int sum = 0;

                for (int k = i; k <= j; k++) {
                    sum += arr[k];
                }

                maxSum = Math.max(maxSum, sum);
            }
        }

        return maxSum;
    }

    // Better Solution - O(n^2)
    static int betterSol(int[] arr) {

        int n = arr.length;
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {

            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                maxSum = Math.max(maxSum, sum);
            }
        }

        return maxSum;
    }

    // Optimal Solution (Kadane's Algorithm) - O(n)
    static int optimalSol(int[] arr) {

        int maxSum = Integer.MIN_VALUE;
        int sum = 0;

        for (int num : arr) {
            sum += num;
            maxSum = Math.max(maxSum, sum);

            if (sum < 0) sum = 0;
        }

        return maxSum;
    }

    // Return Maximum Sum Subarray
    static List<Integer> optimalSolReturnArray(int[] arr) {

        int maxSum = Integer.MIN_VALUE;
        int sum = 0;

        int start = 0;
        int ansStart = 0;
        int ansEnd = 0;

        for (int i = 0; i < arr.length; i++) {

            if (sum == 0) {
                start = i;
            }

            sum += arr[i];

            if (sum > maxSum) {
                maxSum = sum;
                ansStart = start;
                ansEnd = i;
            }

            if (sum < 0) {
                sum = 0;
            }
        }

        List<Integer> result = new ArrayList<>();

        for (int i = ansStart; i <= ansEnd; i++) {
            result.add(arr[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};

        System.out.println("Maximum Sum: " + optimalSol(arr));
        System.out.print("Maximum Sum Subarray: " + optimalSolReturnArray(arr));
    }


}
