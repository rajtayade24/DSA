package com.java.dsa.array;

public class L8BestTimeToBuyAndSellStock {

    // Optimal Solution - O(n)
    static int optimalSol(int[] nums) {

        int minPrice = nums[0];
        int maxProfit = 0;

        for (int i = 1; i < nums.length; i++) {

            int profit = nums[i] - minPrice;

            maxProfit = Math.max(maxProfit, profit);

            minPrice = Math.min(minPrice, nums[i]);
        }

        return maxProfit;
    }

    // Brute Force Solution - O(n²)
    static int bruteSol(int[] nums) {

        int n = nums.length;
        int maxProfit = 0;

        for (int i = 0; i < n; i++) {
            int buy = nums[i];
            int maxPrice = nums[i];

            // Find the maximum selling price after buying
            for (int j = i + 1; j < n; j++) {
                if (nums[j] > maxPrice) {
                    maxPrice = nums[j];
                }
            }

            maxProfit = Math.max(maxProfit, maxPrice - buy);
        }

        return maxProfit;
    }

    public static void main(String[] args) {

        int[] nums = {7, 1, 5, 3, 6, 4};

        System.out.println("Maximum Profit: " + optimalSol(nums));
    }
}