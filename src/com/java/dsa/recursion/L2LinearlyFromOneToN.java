package com.java.dsa.recursion;

public class L2LinearlyFromOneToN {

    static void rec(int i, int n) {
        if (i > n) return;
        System.out.print(i + " ");
        rec(i + 1, n);
    }

    static void rec(int n) {
        if (n <= 0) return;
        rec(n - 1);
        System.out.print(n + " ");
    }

    public static void main(String[] args) {
        rec(1, 8);
        System.out.println();
        rec(8);
    }
}
