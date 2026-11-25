package com.java.dsa.bitManipulation;

public class L2RemoveTheLastMostSetBit {

    static int sol(int n) {
        return n & (n - 1);
    }

    public static void main(String[] args) {
        int n = 40;

        System.out.println("Ans: " +sol(n));
    }
}
