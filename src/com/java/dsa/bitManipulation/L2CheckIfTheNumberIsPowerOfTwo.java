package com.java.dsa.bitManipulation;

public class L2CheckIfTheNumberIsPowerOfTwo {

    static boolean sol(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {
        int n = 16;

        System.out.println("Ans: " + sol((n)));
    }
}
