package com.java.dsa.binarySearch;

public class L18BooksAllocation {

    static int countStudents(int[] arr, int pages) {
        int studCount = 1, pagesCount = 0;

        for (int el : arr) {
            if (pagesCount + el <= pages)
                pagesCount += el;
            else {
                studCount++;
                pagesCount = el;
            }
        }
        return studCount;
    }

    static int linearSearch(int[] arr, int students) {
        if (students > arr.length) return -1;

        int low = 0;
        int high = 0;
        for (int el : arr) {
            if (el > low) low = el;
            high += el;
        }

        for (int p = low; p <= high; p++) {
            if (countStudents(arr, p) == students)
                return p;
        }
        return -1;
    }

    static int binarySearch(int[] arr, int students) {
        if (students > arr.length) return -1;

        int low = 0;
        int high = 0;
        for (int el : arr) {
            if (el > low) low = el;
            high += el;
        }

        while (low <= high) {
            int mid = (low + high) / 2;

            if (countStudents(arr, mid) <= students) {
                high = mid - 1;
            } else low = mid + 1;
        }
        return high + 1; // or low
    }

    public static void main(String[] args) {
        int[] arr = {25, 46, 28, 49, 24};
        int students = 4;

        System.out.println("Ans: " + linearSearch(arr, students));
        System.out.println("Ans: " + binarySearch(arr, students));
    }
}