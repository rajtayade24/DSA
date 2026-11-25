package com.java.dsa.array;

public class L1LargestElement {

    static int sol(int[] arr) {
        int largestNo = arr[0];

        for (int el : arr) {
            if (largestNo < el) {
                largestNo = el;
            }
        }
        return largestNo;
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 7, 5, 3, 5, 8, 3, 2};
        System.out.println("Largest element: " + sol(arr));
    }
}
