package com.java.dsa.binarySearch;

public class L10FindSquareRoot {

    static int linearSearch(int n) {
        int ans = 0;

        for (int i = 1; i <= n; i++) {
            if (i * i <= n) ans = i;
            else break;
        }
        return ans;
    }


    static int binarySearch(int n) {

        int left = 1, right = n;
        int ans = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (mid * mid <= n) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("Ans: " + linearSearch(26));
        System.out.println("Ans: " + binarySearch(0));
    }
}
