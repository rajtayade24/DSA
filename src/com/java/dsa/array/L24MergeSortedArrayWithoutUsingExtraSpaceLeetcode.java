package com.java.dsa.array;

import java.util.Arrays;

public class L24MergeSortedArrayWithoutUsingExtraSpaceLeetcode {

    static void swap(int[] nums1, int[] nums2, int i, int j) {
        int temp = nums1[i];
        nums1[i] = nums2[j];
        nums2[j] = temp;
    }

    static void betterSol(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;

        int i = 0, j = 0;
        int idx = 0;

        while (i < m || j < n) {

            if (nums1[i] > nums2[j]) {
                swap(nums1, nums2, i, j);
                i--;
                j++;
            } else
                break;
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
    }

    static void optimalSol(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int len = m + n;
        int gap = len / 2 + len % 2;

        while (gap > 0) {
            int left = 0, right = left + gap;

            while (right < len) {
                if (left < m && right >= m) { // nums1 & nums2
                    int i = left, j = right - m;
                    if (nums1[i] > nums2[j]) {
                        swap(nums1, nums2, i, j);
                    }
                } else if (left >= m) { // nums2 & nums2
                    int i = left - m, j = right - m;
                    if (nums2[i] > nums2[j]) {
                        swap(nums2, nums2, i, j);
                    }
                } else {// nums1 & nums1
                    int i = left, j = right;
                    if (nums1[i] > nums1[j]) {
                        swap(nums1, nums1, i, j);
                    }
                }
                left++;
                right++;
            }
            if (gap == 1)
                break;
            gap = gap / 2 + gap % 2;
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5, 7, 0, 0, 0, 0, 0};
        int[] arr2 = {0, 2, 6, 8, 9};

        optimalSol(arr1, arr2);
        System.out.println(Arrays.toString(arr1));
    }
}