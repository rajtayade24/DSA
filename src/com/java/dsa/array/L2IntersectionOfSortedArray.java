package com.java.dsa.array;

import java.util.Arrays;

public class L2IntersectionOfSortedArray {

    static int[] sol(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;

        int[] ans = new int[Math.min(n1, n2)];

        int i = 0, j = 0, k = 0;

        while (i < n1 && j < n2) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                // Add only if it is not already added
                if (k == 0 || ans[k - 1] != nums1[i]) {
                    ans[k++] = nums1[i];
                }
                i++;
                j++;
            }
        }

        return Arrays.copyOf(ans, k); // return only active elements
    }

    public static void main(String[] args) {
        int[] nums1 = {4, 5, 7, 8, 9};
        int[] nums2 = {1, 3, 4, 4, 5, 6, 7};

        System.out.print(Arrays.toString(sol(nums1, nums2)));
    }
}
