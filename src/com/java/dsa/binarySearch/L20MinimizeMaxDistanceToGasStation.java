package com.java.dsa.binarySearch;

import java.util.PriorityQueue;

public class L20MinimizeMaxDistanceToGasStation {

    static double usingPriorityQueue(int[] arr, int k) {
        int n = arr.length;

        int[] howMany = new int[n - 1];

        PriorityQueue<double[]> pq = // pq.offer(new double[]{10.5, 2}):         The queue stores arrays of type
                new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));

        // Initial intervals
        for (int i = 0; i < n - 1; i++) {
            pq.offer(new double[]{arr[i + 1] - arr[i], i});
        }

        // Insert k gas stations
        for (int gasStations = 1; gasStations <= k; gasStations++) {

            double[] tp = pq.poll();
            int secInd = (int) tp[1];

            howMany[secInd]++;

            double iniDiff = arr[secInd + 1] - arr[secInd];
            double newSecLen =
                    iniDiff / (double) (howMany[secInd] + 1);

            pq.offer(new double[]{newSecLen, secInd});
        }

        return pq.peek()[0];
    }


    static int countRequiredStations(int[] arr, double dist) {
        int stations = 0;
        for (int i = 1; i < arr.length; i++) {
            double gap = arr[i] - arr[i - 1];
            stations += (int) (gap / dist);

            // If the gap is an exact multiple of dist,
            if (gap % dist == 0) {
                stations--;
            }
        }
        return stations;
    }

    static double binarySearch(int[] arr, int k) {
        double left = 0;
        double right = 0;

        for (int i = 1; i < arr.length; i++) {
            right = Math.max(right, arr[i] - arr[i - 1]);
        }

        double eps = 1e-6;

        while (right - left > eps) {
            double mid = left + (right - left) / 2.0;

            int requiredStations = countRequiredStations(arr, mid);
            if (requiredStations > k) {
                left = mid;
            } else {
                right = mid;
            }
        }

        return right;
    }

    public static void main(String[] args) {
//        int[] arr = {3, 6, 12, 19, 33, 44, 67, 72, 89, 95};
//        int k = 2;
//        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//        int k = 1;
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int k = 10;


        System.out.println("Ans: " + binarySearch(arr, k));
        System.out.println("Ans: " + usingPriorityQueue(arr, k));
    }
}
