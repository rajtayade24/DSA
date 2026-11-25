package com.java.dsa.array;

import java.util.Arrays;

public class L2UnionOfSortedArray {

    static int[] sol(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;

        int[] result = new int[n1 + n2];

        int i = 0, j = 0, k = 0;

        while (i < n1 && j < n2) {
            if (nums1[i] < nums2[j]) {
                if (k == 0 || result[k - 1] != nums1[i]) {
                    result[k++] = nums1[i];
                }
                i++;
            } else if (nums1[i] > nums2[j]) {
                if (k == 0 || result[k - 1] != nums2[j]) {
                    result[k++] = nums2[j];
                }
                j++;
            } else {
                if (k == 0 || result[k - 1] != nums1[i]) {
                    result[k++] = nums1[i];
                }
                i++;
                j++;
            }
        }

        while (i < n1) {
            if (k == 0 || result[k - 1] != nums1[i]) {
                result[k++] = nums1[i];
            }
            i++;
        }

        while (j < n2) {
            if (k == 0 || result[k - 1] != nums2[j]) {
                result[k++] = nums2[j];
            }
            j++;
        }

        return Arrays.copyOf(result, k);
    }

    public static void main(String[] args) {
        int[] nums1 = {4, 5, 7, 8, 9};
        int[] nums2 = {1, 3, 4, 4, 5, 6, 7};

        System.out.print(Arrays.toString(sol(nums1, nums2)));
    }
}
