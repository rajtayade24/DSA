package com.java.dsa.binarySearch;

public class L12KokoEatingBananas {

    static int max(int[] piles) {
        int max = piles[0];

        for (int num : piles) {
            max = Math.max(max, num);
        }
        return max;
    }

    static long helper(int[] piles, int k) {
        long cnt = 0;

        for (int pile : piles) {
            cnt += (int) Math.ceil((double) pile / k);
        }

        return cnt;
    }

    static int linearSearch(int[] piles, int h) {
        int max = max(piles);

        for (int k = 1; k <= max; k++) {

            long requiredTime = helper(piles, k);

            if (requiredTime <= h) {
                return k;
            }
        }
        return -1;
    }

    static int binarySearch(int[] piles, int h) {
        int left = 1;
        int right = max(piles);

        int ans = 0;
        while (left <= right) {
            int mid = (left + right) / 2;

            long requiredTime = helper(piles, mid);
            if (requiredTime <= h) {
                ans = mid;  // store valid speed
                right = mid - 1; // try smaller speed
            } else
                left = mid + 1; // need faster speed
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] piles = {3, 6, 7, 11};
        int h = 8;
        System.out.println("Ans: " + linearSearch(piles, h));
        System.out.println("Ans: " + binarySearch(piles, h));
    }
}
