package com.java.dsa.stackAndQueue;

public class L7NumberOfGreaterElementsToTheRight {

    static int[] bruteSol(int[] arr, int[] indices) {

        int n = arr.length;
        int[] ans = new int[indices.length];

        for (int i = 0; i < indices.length; i++) {

            int idx = indices[i];
            int cnt = 0;

            for (int j = idx + 1; j < n; j++) {
                if (arr[j] > arr[idx]) cnt++;
            }

            ans[i] = cnt;
        }

        return ans;
    }

    public static void main(String[] args) {
//        int[] arr = {3, 4, 2, 7, 5, 8, 10, 6};
//        int[] indices = {0, 5};  // 6,1

        int[] arr = {1, 2, 3, 4, 1};
        int[] indices = {0, 3};  // 3,0

        int[] ans = bruteSol(arr, indices);

        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}
