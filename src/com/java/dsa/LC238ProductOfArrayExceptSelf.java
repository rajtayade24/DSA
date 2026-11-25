package com.java.dsa;

import java.util.Arrays;

public class LC238ProductOfArrayExceptSelf {

    static int[] selfTry(int[] nums) {
        int n = nums.length;
        int[] prefProd = new int[n];
        int[] postProd = new int[n];
        int[] ans = new int[n];

        int product = 1;
        for (int i = 0; i < n; i++) {
            prefProd[i] = product;
            product *= nums[i];
        }

        product = 1;

        for (int i = n - 1; i >= 0; i--) {
            postProd[i] = product;
            product *= nums[i];
        }

        for (int i = 0; i < n; i++) {
            ans[i] = prefProd[i] * postProd[i];
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};

        System.out.println(Arrays.toString(selfTry(nums)));

    }
}
