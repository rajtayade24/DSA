package com.java.dsa.array.sorting;

import java.util.Arrays;

public class S1BubbleSort {

    /// Compare adjacent elements and swap them if they are in the wrong order.
    static void bubbleSort(int[] arr, int n) {

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) { // fix: n-i-1 to avoid out-of-bounds
                if (arr[j] > arr[j + 1]) {
                    // swap arr[j] and arr[j + 1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 3, 5, 1};

        bubbleSort(arr, arr.length);

        System.out.println("Sorted array is:" + Arrays.toString(arr));
    }
}
