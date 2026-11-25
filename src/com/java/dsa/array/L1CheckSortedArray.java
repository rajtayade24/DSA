package com.java.dsa.array;

public class L1CheckSortedArray {

    static boolean sol(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] > arr[i])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 6, 7, 8, 9};

        if (sol(arr))
            System.out.println("The given array is sorted");
        else
            System.out.println("The given array is not sorted");
    }
}
