package com.java.dsa.recursion;

public class L3ParameterizedVsFunctionalRecursion {

    // Parameterized Recursion
    static void parameterized(int i, int sum) {
        if (i < 1) {
            System.out.println("Parameterized: " + sum);
            return;
        }
        parameterized(i - 1, sum + i);
    }

    // Functional Recursion
    static int functional(int n) {
        if (n == 0) {
            return 0;
        }
        return n + functional(n - 1);
    }

    public static void main(String[] args) {
        parameterized(3, 0);
        System.out.println("Functional: " + functional(3));
    }
}
