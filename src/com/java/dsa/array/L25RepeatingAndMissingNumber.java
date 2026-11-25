package com.java.dsa.array;

public class L25RepeatingAndMissingNumber {

    // ============================================================
    // 1. Mathematical Approach
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    // ============================================================
    static int[] betterSol(int[] arr) {

        int n = arr.length;

        // Sum of numbers from 1 to n
        long SN = (long) n * (n + 1) / 2;

        // Sum of squares of numbers from 1 to n
        long S2N = (long) n * (n + 1) * (2L * n + 1) / 6;

        long S = 0;
        long S2 = 0;

        // Calculate actual sum and actual sum of squares
        for (int el : arr) {
            S += el;
            S2 += (long) el * el;
        }

        // x = repeating number
        // y = missing number

        // x - y
        long diff = S - SN;

        // x² - y²
        long sqdiff = S2 - S2N;

        // x² - y² = (x-y)(x+y)
        // Therefore:
        // x+y = (x²-y²)/(x-y)
       long add = sqdiff / diff;

        // x = ((x-y) + (x+y)) / 2
        long x = (diff + add) / 2;

        // y = x - (x-y)
        long y = x - diff;

        return new int[]{(int) x, (int) y};
    }


    // ============================================================
    // 2. Hashing Approach
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    // ============================================================
    static int[] hashingSol(int[] arr) {

        int n = arr.length;

        // Java array syntax
        int[] hash = new int[n + 1];

        // Store frequency of every number
        for (int el : arr) {
            hash[el]++;
        }

        int p = -1; // Repeating number
        int q = -1; // Missing number

        for (int i = 1; i <= n; i++) {

            if (hash[i] == 2) {
                p = i;
            }

            if (hash[i] == 0) {
                q = i;
            }

            if (p != -1 && q != -1) {
                break;
            }
        }

        return new int[]{p, q};
    }


    // ============================================================
    // Main Method
    // ============================================================
    public static void main(String[] args) {

        int[] arr = {4, 3, 6, 2, 1, 1};

        // Mathematical approach
        int[] ans1 = betterSol(arr);

        System.out.println("Mathematical Approach:");
        System.out.println("Repeating Number = " + ans1[0]);
        System.out.println("Missing Number    = " + ans1[1]);


        System.out.println();


        // Hashing approach
        int[] ans2 = hashingSol(arr);

        System.out.println("Hashing Approach:");
        System.out.println("Repeating Number = " + ans2[0]);
        System.out.println("Missing Number    = " + ans2[1]);
    }
}