package com.java.dsa.binarySearch;

public class L15CapacityToShipPackagesWithinDDays {

    static int min(int[] nums) {
        int ans = Integer.MAX_VALUE;
        for (int el : nums) ans = Math.min(ans, el);
        return ans;
    }

    static int max(int[] nums) {
        int ans = Integer.MIN_VALUE;
        for (int el : nums) ans = Math.max(ans, el);
        return ans;
    }

    static int linearSearch(int[] weights, int days) {

        int maxWeight = Integer.MIN_VALUE;
        int totalWt = 0;
        for (int w : weights) {
            maxWeight = Math.max(maxWeight, w);
            totalWt += w;
        }

        for (int cap = maxWeight; cap <= totalWt; cap++) {

            int requiredDays = 1;
            int load = 0;

            for (int weight : weights) {

                if (load + weight > cap) {
                    requiredDays++;
                    load = weight;
                } else {
                    load += weight;
                }
            }

            if (requiredDays <= days) {
                return cap;
            }
        }

        return -1;
    }

    static int requiredDays(int[] weights, int cap) {
        int requiredDays = 1;
        int load = 0;

        for (int weight : weights) {
            if (load + weight <= cap) {
                load += weight;
            } else {
                requiredDays++;
                load = weight;
            }
        }
        return requiredDays;
    }

    static int binarySearch(int[] weights, int days) {
        int left = Integer.MIN_VALUE;
        int right = 0;
        for (int w : weights) {
            left = Math.max(left, w);
            right += w;
        }

        int ans = Integer.MAX_VALUE;
        while (left <= right) {
            int mid = (left + right) / 2;

            if (requiredDays(weights, mid) <= days) {
                ans = Math.min(ans, mid);
                right = mid - 1;
            } else left = mid + 1;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] weights = {3, 2, 2, 4, 1, 4};
        int days = 3;

        System.out.println("Ans: " + linearSearch(weights, days));
        System.out.println("Ans: " + binarySearch(weights, days));
    }
}
