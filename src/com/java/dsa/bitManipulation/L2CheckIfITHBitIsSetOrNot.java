package com.java.dsa.bitManipulation;

public class L2CheckIfITHBitIsSetOrNot {

    static boolean byLeftShiftOperator(int n, int i) {
        if ((n & (1 << i)) != 0) return true;
        else return false;
    }

    static boolean byRightShiftOperator(int n, int i) {
        if (((n >> i) & 1) != 0) return true;
        else return false;
    }

    static boolean byRightShiftOperator1(int n, int i) {
        if ((n >> i) % 2 != 0) return true;
        else return false;
    }

    public static void main(String[] args) {
        int n = 13, i = 2; // true
//        int n = 13, i = 1; // false

        System.out.println("Ans: " + byLeftShiftOperator(n, i));
        System.out.println("Ans: " + byRightShiftOperator(n, i));
        System.out.println("Ans: " + byRightShiftOperator1(n, i));
    }
}
