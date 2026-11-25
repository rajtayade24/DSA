package com.java.dsa.array;

public class L1RemoveDuplicates {

    static int removeDuplicates(int[] arr) {

        int idx = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[idx] != arr[i]) {
                idx++;
                arr[idx] = arr[i];
            }
        }

        return idx + 1;   // length of unique elements
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 4, 5, 6, 6, 7, 8, 9};

        System.out.println("Unique array size: " + removeDuplicates(arr));
    }
}