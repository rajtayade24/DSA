package com.java.dsa.array;

import java.util.Arrays;

public class LCountInversions {

    static int merge(int[] arr, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];

        int left = low, right = mid + 1, k = 0;

        int cnt = 0;
        while (left <= mid && right <= high) {
            // Left is smaller
            if (arr[left] <= arr[right]) {
                temp[k++] = arr[left++];
            }
            // Right is smaller
            else {
                cnt += (mid - left + 1);
                temp[k++] = arr[right++];
            }
        }

        while (left <= mid) {
            temp[k++] = arr[left++];
        }

        while (right <= high) {
            temp[k++] = arr[right++];
        }

        // copy back to original array
        for (int i = 0; i < temp.length; i++) {
            arr[low + i] = temp[i];
        }

        return cnt;
    }

    static int mergeSort(int[] arr, int low, int high) {
        int cnt = 0;

        if (low >= high)
            return cnt;

        int mid = low + (high - low) / 2;

        cnt += mergeSort(arr, low, mid);
        cnt += mergeSort(arr, mid + 1, high);

        cnt += merge(arr, low, mid, high);

        return cnt;
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 2, 4, 1};

        System.out.println("Inversions: " + mergeSort(arr, 0, arr.length - 1));

        System.out.println("Sorted array is: " + Arrays.toString(arr));
    }
}
