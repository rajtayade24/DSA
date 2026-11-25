package com.java.dsa.stackAndQueue;

public class L8TrappingRainWater {

    static int optimalSol(int[] height) {
        int n = height.length;

        int left = 0;
        int right = n - 1;

        int leftMax = 0;
        int rightMax = 0;

        int total = 0;
        while (left <= right) {
            if (height[left] <= height[right]) {
                if (height[left] >= leftMax)
                    leftMax = height[left];
                else
                    total += leftMax - height[left];

                left++;
            } else {
                if (height[right] >= rightMax)
                    rightMax = height[right];
                else
                    total += rightMax - height[right];

                right--;
            }
        }
        return total;
    }

    static int betterSol(int[] height) {
        int n = height.length;

        int[] prefMax = new int[n];
        prefMax[0] = height[0];

        for (int i = 1; i < n; i++) {
            prefMax[i] = Math.max(prefMax[i - 1], height[i]);
        }

        int rightMax = height[n - 1];
        int total = 0;

        for (int i = n - 1; i >= 0; i--) {
            rightMax = Math.max(rightMax, height[i]);
            total += Math.min(prefMax[i], rightMax) - height[i];
        }

        return total;
    }

    static int bruteSol(int[] height) {
        int n = height.length;

        int[] prefMax = new int[n];
        int[] sufMax = new int[n];

        prefMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            if (height[i] < prefMax[i - 1])
                prefMax[i] = prefMax[i - 1];
            else
                prefMax[i] = height[i];
        }

        sufMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (height[i] < sufMax[i + 1])
                sufMax[i] = sufMax[i + 1];
            else
                sufMax[i] = height[i];
        }

        int total = 0;
        for (int i = 0; i < n; i++) {
            int leftMax = prefMax[i], rightMax = sufMax[i];
            if (height[i] < leftMax && height[i] < rightMax)
                total += Math.min(leftMax, rightMax) - height[i];
        }
        return total;
    }

    public static void main(String[] args) {
//        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int[] height = {4, 2, 0, 3, 2, 5};

        System.out.println(bruteSol(height));
        System.out.println(betterSol(height));
        System.out.println(optimalSol(height));
    }
}
