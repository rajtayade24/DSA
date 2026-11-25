package com.java.dsa.bitManipulation;

public class L3MinimumBitFlipsToConvertNumber {

    static int sol(int start, int goal) {

        int ans = start ^ goal;

        int cnt = 0;
        while (ans > 0) {
            cnt++;
            ans = ans & (ans - 1);
        }
        return cnt;
    }

    public static void main(String[] args) {
        int start = 10, goal = 7;

        System.out.println("Ans: " + sol(start, goal));
    }
}