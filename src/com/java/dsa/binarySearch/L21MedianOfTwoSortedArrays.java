package com.java.dsa.binarySearch;

import java.util.ArrayList;
import java.util.List;

public class L21MedianOfTwoSortedArrays {

    // Brute Force Solution
    // Time: O(n + m)
    // Space: O(n + m)
    static double bruteSol(int[] nums1, int[] nums2) {

        int n = nums1.length;
        int m = nums2.length;

        List<Integer> merged = new ArrayList<>();

        int i = 0;
        int j = 0;

        // Merge both sorted arrays
        while (i < n && j < m) {
            if (nums1[i] <= nums2[j]) {
                merged.add(nums1[i]);
                i++;
            } else {
                merged.add(nums2[j]);
                j++;
            }
        }

        // Add remaining elements of nums1
        while (i < n) {
            merged.add(nums1[i]);
            i++;
        }

        // Add remaining elements of nums2
        while (j < m) {
            merged.add(nums2[j]);
            j++;
        }

        int len = n + m;

        // Odd length
        if (len % 2 == 1) {
            return merged.get(len / 2);
        }

        // Even length
        return (merged.get(len / 2) + merged.get(len / 2 - 1)) / 2.0;
    }


    // Better Solution
    // Time: O(n + m)
    // Space: O(1)
    static double betterSol(int[] nums1, int[] nums2) {

        int n = nums1.length;
        int m = nums2.length;
        int len = n + m;

        int i = 0;
        int j = 0;

        int ind1 = len / 2;
        int ind2 = ind1 - 1;

        int cnt = 0;

        int el1 = -1;
        int el2 = -1;

        // Traverse both arrays without storing merged array
        while (i < n && j < m) {

            if (nums1[i] <= nums2[j]) {

                if (cnt == ind1) el1 = nums1[i];
                if (cnt == ind2) el2 = nums1[i];

                i++;
                cnt++;
            } else {

                if (cnt == ind1) el1 = nums2[j];
                if (cnt == ind2) el2 = nums2[j];

                j++;
                cnt++;
            }
        }

        // Remaining elements of nums1
        while (i < n) {

            if (cnt == ind1) el1 = nums1[i];
            if (cnt == ind2) el2 = nums1[i];

            i++;
            cnt++;
        }

        // Remaining elements of nums2
        while (j < m) {

            if (cnt == ind1) el1 = nums2[j];
            if (cnt == ind2) el2 = nums2[j];

            j++;
            cnt++;
        }

        // Odd length
        if (len % 2 == 1) {
            return el1;
        }

        // Even length
        return (el1 + el2) / 2.0;
    }


    // Optimal Binary Search Solution
    // Time: O(log(min(n, m)))
    // Space: O(1)
    static double binarySearch(int[] nums1, int[] nums2) {

        // Always perform binary search on the smaller array
        if (nums1.length > nums2.length) {
            return binarySearch(nums2, nums1);
        }

        int n = nums1.length;
        int m = nums2.length;

        int left = 0;
        int right = n;

        int total = n + m;

        // Number of elements required on the left side
        int leftHalf = (total + 1) / 2;

        while (left <= right) {

            // Partition of nums1
            int cut1 = (left + right) / 2;

            // Partition of nums2
            int cut2 = leftHalf - cut1;

            // Left and right elements of nums1
            int left1;

            if (cut1 == 0) {
                left1 = Integer.MIN_VALUE;
            } else {
                left1 = nums1[cut1 - 1];
            }

            int right1;

            if (cut1 == n) {
                right1 = Integer.MAX_VALUE;
            } else {
                right1 = nums1[cut1];
            }

            // Left and right elements of nums2
            int left2;

            if (cut2 == 0) {
                left2 = Integer.MIN_VALUE;
            } else {
                left2 = nums2[cut2 - 1];
            }

            int right2;

            if (cut2 == m) {
                right2 = Integer.MAX_VALUE;
            } else {
                right2 = nums2[cut2];
            }

            // Correct partition found
            if (left1 <= right2 && left2 <= right1) {

                // Odd number of elements
                if (total % 2 == 1) {
                    return Math.max(left1, left2);
                }

                // Even number of elements
                return (Math.max(left1, left2)
                        + Math.min(right1, right2)) / 2.0;
            }

            // We have taken too many elements from nums1
            if (left1 > right2) {
                right = cut1 - 1;
            }

            // We need to take more elements from nums1
            else {
                left = cut1 + 1;
            }
        }

        return 0.0;
    }

    public static void main(String[] args) {

        int[] nums1 = {1, 3, 4, 7, 10, 12};
        int[] nums2 = {2, 3, 6, 15};

        System.out.println("Brute Answer: " + bruteSol(nums1, nums2));

        System.out.println("Better Answer: " + betterSol(nums1, nums2));

        System.out.println("Binary Search Answer: " + binarySearch(nums1, nums2));
    }
}