package com.java.dsa.binarySearch;

public class L11FindNthRootOfInteger {

    static int linearSearch(int n, int p) {

        for (int i = 1; i < n; i++) {
            int ans = 1, x = p;

            while (x > 0) {
                ans *= i;
                x--;
            }

            if (ans == n) return i;
            else if(ans > n) break;
        }
        return -1;
    }

    static int binarySearch(int n, int p) {
        int left = 1, right = n;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            int ans = 1, x = p;

            while (x > 0) {
                ans *= mid;
                x--;
            }

            if (ans == n) return mid;
            else if (ans < n) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println("Ans: " + linearSearch(27, 3));
        System.out.println("Ans: " + binarySearch(27, 3));
    }
}
