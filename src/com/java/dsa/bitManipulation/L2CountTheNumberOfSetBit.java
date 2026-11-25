package com.java.dsa.bitManipulation;

public class L2CountTheNumberOfSetBit {

    static int optimalSol(int n) {

        int cnt = 0;
        while (n > 0) {
            cnt++;
            n = n & (n - 1);
        }
        return cnt;
    }

    static int sol(int n) {

        int cnt = 0;
        while (n > 0) {
            cnt += (n % 2);
            n = n / 2;
        }

        return cnt;
    }

    public static void main(String[] args) {
        int n = 13;

        System.out.println("Ans: " + sol(n));
        System.out.println("Ans: " + optimalSol(n));
    }
}
