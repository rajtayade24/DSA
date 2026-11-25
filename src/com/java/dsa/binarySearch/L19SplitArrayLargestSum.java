package com.java.dsa.binarySearch;

public class L19SplitArrayLargestSum {

    static int countStudents(int[] arr, int maxSum) {
        int students = 1;
        int currentSum = 0;

        for (int num : arr) {
            if (currentSum + num <= maxSum) {
                currentSum += num;
            } else {
                students++;
                currentSum = num;
            }
        }

        return students;
    }

    static int linearSearch(int[] nums, int k) {
        if (k > nums.length) return -1;

        int low = 0;
        int high = 0;

        // Find the search range:
        // low  = maximum element
        // high = total sum
        for (int num : nums) {
            low = Math.max(low, num);
            high += num;
        }

        // Try every possible answer
        for (int maxSum = low; maxSum <= high; maxSum++) {

            int subArrays = countStudents(nums, maxSum);

            // If we can split into k or fewer parts,
            // this is the minimum possible answer.
            if (subArrays <= k) {
                return maxSum;
            }
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
        int[] nums = {1, 2, 3, 4, 5};
        int k = 1;
//      int[] nums = {7, 2, 5, 10, 8};
//      int k = 2;
//      int[] nums = {1, 4, 4};
//      int k = 3;

        System.out.println("Ans: " + linearSearch(nums, k));
        System.out.println("Ans: " + binarySearch(nums, k));
    }
}