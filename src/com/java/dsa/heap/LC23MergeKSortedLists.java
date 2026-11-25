package com.java.dsa.heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LC23MergeKSortedLists {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> pq =
                new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));

        // Add the head of each non-empty list
        for (ListNode node : lists) {
            if (node != null) {
                pq.offer(node);
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        while (!pq.isEmpty()) {
            ListNode node = pq.poll();

            curr.next = node;
            curr = curr.next;

            if (node.next != null) {
                pq.offer(node.next);
            }
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();


    }
}
