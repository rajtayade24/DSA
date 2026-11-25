package com.java.dsa.stackAndQueue;

import java.util.HashMap;
import java.util.Stack;

public class L5NextGreaterElement {

    static int[] usingMonotonicStack(int[] nums1, int[] nums2) {

        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> st = new Stack<>();

        for (int i = nums2.length - 1; i >= 0; i--) {

            while (!st.isEmpty() && st.peek() <= nums2[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                map.put(nums2[i], -1);
            } else {
                map.put(nums2[i], st.peek());
            }

            st.push(nums2[i]);
        }

        int[] ans = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            ans[i] = map.get(nums1[i]);
        }

        return ans;
    }

    static int[] selfTry(int[] nums1, int[] nums2) {

        int[] ans = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {

            boolean found = false;
            ans[i] = -1;

            for (int j = 0; j < nums2.length; j++) {

                if (!found && nums1[i] == nums2[j]) {
                    found = true;
                }

                if (found && nums2[j] > nums1[i]) {
                    ans[i] = nums2[j];
                    break;      // first greater element
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};

        int[] ans = usingMonotonicStack(nums1, nums2);

        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}
