package com.java.dsa.bitManipulation;

public class L9DivideTwoIntegersWithoutUsingMultiplicationAndDivisionOperators {

    static int optimalSol(int dividend, int divisor) {
        if (dividend == divisor) return 1;

        boolean signed = false; // +ve

        if ((dividend >= 0 && divisor < 0)
                || (dividend < 0 && divisor >= 0))
            signed = true;

        long n = Math.abs((long) dividend);
        long d = Math.abs((long) divisor);
        long ans = 0;

        while (n >= d) {
            int cnt = 0;
            while (n >= (d << (cnt + 1))) {
                cnt++;
            }

            ans += (1L << cnt);
            n -= (d << cnt);
        }

        if (ans > Integer.MAX_VALUE) {
            return signed ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }

        return signed ? (int) -ans : (int) ans;
    }

    static int selfTry(int dividend, int divisor) {
        int sum = 0, cnt = 0;
        while (sum + divisor <= dividend) {
            cnt++;
            sum += divisor;
        }
        return cnt;
    }

    public static void main(String[] args) {
        int dividend = 22, divisor = 3;

        System.out.println("Ans: " + selfTry(dividend, divisor));
        System.out.println("Ans: " + optimalSol(dividend, divisor));
    }
}
