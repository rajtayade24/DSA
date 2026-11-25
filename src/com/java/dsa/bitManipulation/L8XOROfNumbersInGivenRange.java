package com.java.dsa.bitManipulation;

public class L8XOROfNumbersInGivenRange {

    static int xorUptoN(int n) {
        return switch (n % 4) {
            case 0 -> n;
            case 1 -> 1;
            case 2 -> n + 1;
            default -> 0;
        };
    }

    static int optimalSol(int l, int r) {
        return xorUptoN(r) ^ xorUptoN(l - 1);
    }

    public static void main(String[] args) {
        int l = 3, r = 5;

        System.out.println("Ans: " + optimalSol(l, r));
    }
}
