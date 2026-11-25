package com.java.dsa.array.sorting;

import java.util.Arrays;

public class S3InsertionSort {

    /// Pick an element and insert it into its correct position in the sorted part.
    static void insertionSort(int[] arr, int n) {

        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 3, 5, 1};

        insertionSort(arr, arr.length);

        System.out.println("Sorted array is:" + Arrays.toString(arr));
    }
}
