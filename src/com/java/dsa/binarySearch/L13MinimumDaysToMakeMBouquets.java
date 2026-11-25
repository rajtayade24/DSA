package com.java.dsa.binarySearch;

public class L13MinimumDaysToMakeMBouquets {

    static int max(int[] arr) {
        int max = arr[0];

        for (int num : arr) {
            max = Math.max(max, num);
        }
        return max;
    }

    static int linearSearch(int[] bloomDay, int m, int k) {
        if (bloomDay.length < m * k) return -1;

        for (int day = 1; day <= max(bloomDay); day++) {

            int bouckets = 0, cnt = 0;

            for (int el : bloomDay) {
                if (el <= day) cnt++;
                else {
                    bouckets += (cnt / k);
                    cnt = 0;
                }
            }
            bouckets += (cnt / k);
            if (bouckets >= m) return day;
        }
        return -1;
    }

    static int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;

        if (n < m * k) return -1;

        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;

        for (int day : bloomDay) {
            left = Math.min(left, day);
            right = Math.max(right, day);
        }

        int ans = -1;
        while (left <= right) {
            int mid = (left + right) / 2;

            int bouckets = 0, cnt = 0;

            for (int bloom : bloomDay) {
                if (bloom <= mid) cnt++;
                else {
                    bouckets += (cnt / k);
                    cnt = 0;
                }
            }
            bouckets += (cnt / k);
            if (bouckets >= m) {
                ans = mid;
                right = mid - 1;
            } else left = mid + 1;
        }
        return ans;
    }

    static boolean canMakeBouquets(int[] bloomDay, int m, int k, int day) {
        int bouquets = 0;
        int cnt = 0;

        for (int bloom : bloomDay) {
            if (bloom <= day) {
                cnt++;
            } else {
                bouquets += cnt / k;
                cnt = 0;
            }
        }

        bouquets += cnt / k;

        return bouquets >= m;
    }

    static int minDays1(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;

        if ((long) m * k > n) return -1;

        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;

        for (int day : bloomDay) {
            left = Math.min(left, day);
            right = Math.max(right, day);
        }

        int ans = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (canMakeBouquets(bloomDay, m, k, mid)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }


    public static void main(String[] args) {
        int[] bloomDay = {7, 7, 7, 7, 12, 7, 7};
        int m = 2, k = 3;
//        int[] bloomDay = {1, 10, 3, 10, 2};
//        int m = 3, k = 1;

        System.out.println("bouckets: " + linearSearch(bloomDay, m, k));
        System.out.println("bouckets: " + minDays(bloomDay, m, k));
    }
}
