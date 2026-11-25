package com.java.dsa.array;

import java.util.ArrayList;
import java.util.List;

public class L18PascalsTriangle {

    // nCr = n! / (r! * (n-r)!)
    static long nCr(int n, int r) {

        // Always use the smaller value of r
        r = Math.min(r, n - r);

        long res = 1;
        for (int i = 0; i < r; i++) {
            res = res * (n - i);
            res = res / (i + 1);
        }

        return res;
    }

    // Brute Force - Print one row using nCr
    // Time Complexity: O(row²)
    static void printRowBrute(int row) {
        for (int col = 1; col <= row; col++) {
            System.out.print(nCr(row - 1, col - 1) + " ");
        }
        System.out.println();
    }

    // Optimal - Generate one row
    // Time Complexity: O(row)
    static List<Long> printRowOptimal(int row) {

        List<Long> ansRow = new ArrayList<>();

        long ans = 1;
        ansRow.add(ans);

        for (int col = 1; col < row; col++) {
            ans = ans * (row - col);
            ans = ans / col;

            ansRow.add(ans);
        }

        return ansRow;
    }

    // Generate Pascal's Triangle
    // Time Complexity: O(n²)
    static List<List<Long>> printPascalsTriangle(int n) {

        List<List<Long>> triangle = new ArrayList<>();

        for (int row = 1; row <= n; row++) {
            triangle.add(printRowOptimal(row));
        }

        return triangle;
    }

    public static void main(String[] args) {

        int row = 5;
        int col = 3;

        // Find an element
        System.out.println("Element at (" + row + ", " + col + "): "
                + nCr(row - 1, col - 1));

        System.out.println();

        // Print one row (Brute Force)
        System.out.println("Brute Force Row:");
        printRowBrute(6);

        System.out.println();

        // Print one row (Optimal)
        System.out.println("Optimal Row:");
        List<Long> list = printRowOptimal(6);
        System.out.println(list);

        System.out.println();

        // Print Pascal's Triangle
        System.out.println("Pascal's Triangle:");

        List<List<Long>> triangle = printPascalsTriangle(6);

        for (List<Long> r : triangle) {
            for (long num : r) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}