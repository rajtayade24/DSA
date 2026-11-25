package com.java.dsa.binarySearch;

public class L16KthMissingPositiveNumber {

    static int linearSearch(int[] arr, int k) {
        for (int el : arr) {
            if (el < k) k++;
            else break;
        }
        return k;
    }

    static int binarySearch(int[] arr, int k) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            // Number of missing positive integers before arr[mid]
            int missings = arr[mid] - (mid + 1);
            if (missings < k)
                left = mid + 1;
            else
                right = mid - 1;
        }

        return k + right + 1;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 7, 11};
        int k = 5; // Ans:  9
//        int[] arr = {1, 2, 3, 4};
//        int k = 2;
//        int[] arr = {1, 3};
//        int k = 1;

        System.out.println("Ans: " + linearSearch(arr, k));
        System.out.println("Ans: " + binarySearch(arr, k));
    }
}
