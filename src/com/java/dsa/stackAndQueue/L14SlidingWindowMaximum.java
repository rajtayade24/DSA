package com.java.dsa.stackAndQueue;

import java.util.ArrayDeque;
import java.util.Deque;

public class L14SlidingWindowMaximum {

    static int[] optimalSol(int[] nums, int k) {
        int n = nums.length;

        int[] maxArray = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {

            // Remove indices outside the current window
            while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }

            // Remove smaller elements from the back
            while (!deque.isEmpty() &&
                    nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }

            deque.offerLast(i);

            // Store answer when the first window is complete
            if (i >= k - 1) {
                maxArray[i - k + 1] = nums[deque.peekFirst()];
            }
        }

        return maxArray;
    }

    static int[] selfTry(int[] nums, int k) {
        int n = nums.length;

        int[] maxArray = new int[n - k + 1];

        for (int i = 0; i < n - k + 1; i++) {

            int max = nums[i];
            for (int j = i + 1; j < i + k; j++) {
                max = Math.max(max, nums[j]);
            }
            maxArray[i] = max;
        }
        return maxArray;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 7, 1, 6};
        int k = 3;

        System.out.print("Ans:  ");

//        int[] ans = selfTry(nums, k);
        int[] ans = optimalSol(nums, k);

        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}
