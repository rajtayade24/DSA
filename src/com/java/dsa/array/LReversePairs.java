package com.java.dsa.array;

public class LReversePairs {

    static int countPairs(int[] arr, int low, int mid, int high) {

        int cnt = 0;
        int right = mid + 1;

        for (int i = low; i <= mid; i++) {
            while (right <= high && (long) arr[i] > 2L * arr[right]) {
                right++;
            }

            cnt += right - (mid + 1);
        }
        return cnt;
    }

    static void merge(int[] arr, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];

        int left = low, right = mid + 1, k = 0;

        while (left <= mid && right <= high) {
            // Left is smaller
            if (arr[left] <= arr[right]) {
                temp[k++] = arr[left++];
            }
            // Right is smaller
            else {
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
    }

    static int mergeSort(int[] arr, int low, int high) {

        int cnt = 0;

        if (low >= high)
            return cnt;

        int mid = low + (high - low) / 2;

        cnt += mergeSort(arr, low, mid);
        cnt += mergeSort(arr, mid + 1, high);
        cnt += countPairs(arr, low, mid, high);

        merge(arr, low, mid, high);

        return cnt;
    }

    static int reversepairs(int[] arr) {
        return mergeSort(arr, 0, arr.length - 1);
    }

    public static void main(String[] args) {
        int[] arr = {40, 25, 19, 12, 9, 6, 2};

        System.out.println(reversepairs(arr));
    }
}
