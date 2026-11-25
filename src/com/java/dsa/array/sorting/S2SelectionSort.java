package com.java.dsa.array.sorting;

import java.util.Arrays;

public class S2SelectionSort {

    /// Find minimum element in unsorted part and swap it with current position.
    static void selectionSort(int[] arr, int n) {
        for (int i = 0; i < n - 1; i++) {
            int mini = i;

            for (int j = i + 1; j < n; j++) {
                if (arr[mini] > arr[j]) {
                    mini = j;
                }
            }

            // Swap minimum element with current position
            int temp = arr[mini];
            arr[mini] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 3, 5, 1};

        selectionSort(arr, args.length);

        System.out.println("Sorted array is:" + Arrays.toString(arr));
    }
}
