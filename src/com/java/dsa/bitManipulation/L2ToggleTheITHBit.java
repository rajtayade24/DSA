package com.java.dsa.bitManipulation;

public class L2ToggleTheITHBit {

    static int byLeftShiftOperator(int n, int i) {
        return (n ^ (1 << i));
    }

    public static void main(String[] args) {
        int n = 13, i = 2; // 9
//        int n =9, i = 2; // 13

        System.out.println("Ans: " + byLeftShiftOperator(n, i));
    }
}
