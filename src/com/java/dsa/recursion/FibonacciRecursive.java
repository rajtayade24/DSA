package com.java.dsa.recursion;

public class FibonacciRecursive {

    // Recursive function
    static int rec(int n) {
        if (n <= 1) return n;
        return rec(n - 1) + rec(n - 2);
    }

    public static void main(String[] args) {
        int n = 8;
        System.out.println(n + "th element in the recursion series is: " + rec(n));
    }
}
