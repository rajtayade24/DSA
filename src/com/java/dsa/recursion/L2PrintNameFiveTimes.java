package com.java.dsa.recursion;

public class L2PrintNameFiveTimes {

    static void rec(int n) {
        if (n <= 0) return;
        System.out.println("Raj");
        rec(n - 1);
    }

    public static void main(String[] args) {
        rec(5);
    }
}
