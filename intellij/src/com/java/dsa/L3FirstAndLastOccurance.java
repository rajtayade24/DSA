package com.java.dsa;

public class L3FirstAndLastOccurance {

    final L2LowerAndUpperBound bound;

    public L3FirstAndLastOccurance(L2LowerAndUpperBound bound) {
        this.bound = bound;
    }

    static int firstOccur(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        int ans = -1;
        while (left <= right) {

            int mid = (left + right) / 2;

            if (nums[mid] == target) {
                ans = mid;
                right = mid - 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    static int lastOccur(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        int ans = -1;
        while (left <= right) {

            int mid = (left + right) / 2;
            System.out.println("MID: " + mid);
            if (nums[mid] == target) {
                ans = mid;
                left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    // arr[index] >= target
    public static int lowerBound(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        int ans = nums.length;

        while (left <= right) {

            int mid = (left + right) / 2;

            if (nums[mid] >= target) {
                ans = mid;
                right = mid - 1;         // look for more small index on left
            } else {
                left = mid + 1;          // look for bigger index on right
            }
        }

        return ans;
    }

    // arr[index] > target
    public static int upperBound(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        int ans = nums.length;

        while (left <= right) {

            int mid = (left + right) / 2;

            if (nums[mid] > target) {
                ans = mid;
                right = mid - 1;         // look for more small index on left
            } else {
                left = mid + 1;          // look for bigger index on right
            }
        }
        return ans;
    }


    static int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) return new int[]{-1, -1};
//        return new int[]{firstOccur(nums, target), lastOccur(nums, target)};

        int lb = lowerBound(nums, target);
        if (lb == nums.length || nums[lb] != target) return new int[]{-1, -1};
        return new int[]{lb, upperBound(nums, target) - 1};
    }

    static int countOccurance(int[] nums, int target) {
        int lb = lowerBound(nums, target);

        if (lb == nums.length || nums[lb] != target) return 0;
        return upperBound(nums, target) - lb;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 5, 6, 8, 8, 8, 9};
        int target = 8;

        int[] ans = searchRange(nums, target);

        System.out.println("Ans: ");
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }

        System.out.println("Count Occurance: " + countOccurance(nums, target));
    }
}
