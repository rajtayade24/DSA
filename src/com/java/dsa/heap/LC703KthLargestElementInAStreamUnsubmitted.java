package com.java.dsa.heap;

import java.util.PriorityQueue;

class KthLargest {

    int[] nums;
    int k;
    PriorityQueue<Integer> pq = new PriorityQueue<>();

    public KthLargest(int k, int[] nums) {
        this.nums = nums;
        this.k = k;

        for (int i = 0; i < nums.length; i++) {
            pq.offer(nums[i]);

            if (pq.size() > k)
                pq.poll();
        }
    }

    public int add(int val) {
        pq.offer(val);
        pq.poll();

        return pq.peek();
    }
}


public class LC703KthLargestElementInAStreamUnsubmitted {
}
