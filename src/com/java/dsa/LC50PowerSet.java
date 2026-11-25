package com.java.dsa;

public class LC50PowerSet {

    static double myPow(double x, int n) {

        long power = n;
        if (power < 0) {
            x = 1 / x;
            power = -power;
        }

        double ans = 1.0;
        while (power > 0) {
            if (power % 2 == 1) {
                ans = ans * x;
            }
            x = x * x;
            power = power / 2;
        }

        return ans;
    }

    public static void main(String[] args) {
        double x = 2.10000;
        int n = 3;

        System.out.println(myPow(x, n));
    }
}