package com.java.dsa.array.sorting;

import java.util.Arrays;

public class QuickSort {

    // Partition function
    static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        int i = low;
        int j = high;

        while (i < j) {
            while (i <= high - 1 && arr[i] <= pivot) i++;
            while (j >= low + 1 && arr[j] > pivot) j--;

            if (i < j) {
                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap pivot with arr[j]
        int temp = arr[low];
        arr[low] = arr[j];
        arr[j] = temp;

        return j;
    }

    // QuickSort function
    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 3, 5, 1};

        quickSort(arr, 0, arr.length);

        System.out.println("Sorted array is:" + Arrays.toString(arr));
    }
}
