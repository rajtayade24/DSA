package com.java.dsa.bitManipulation;

public class L2ClearTheITHBit {

    static int byLeftShiftOperator(int n, int i) {
        return (n & ~(1 << i));
    }

    public static void main(String[] args) {
        int n = 13, i = 2; // 9

        System.out.println("Ans: " + byLeftShiftOperator(n, i));
    }
}
