package com.java.dsa.linkedList;

import java.util.*;

class ListNode {
    int data;
    ListNode next;
    ListNode child;

    ListNode(int data1) {
        data = data1;
        next = null;
        child = null;
    }
}

public class L24FlattenLinkedList {

    /// OPTIMAL SOL: Using Recursing Merging list one by one
    static ListNode flatten(ListNode head) {

        if (head == null || head.next == null)
            return head;

        head.next = flatten(head.next);

        return merge(head, head.next);
    }

    static ListNode merge(ListNode a, ListNode b) {

        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        while (a != null && b != null) {

            if (a.data <= b.data) {
                temp.child = a;
                a = a.child;
            } else {
                temp.child = b;
                b = b.child;
            }

            temp = temp.child;
            temp.next = null;
        }

        if (a != null)
            temp.child = a;

        if (b != null)
            temp.child = b;

        return dummy.child;
    }

    ///  Using priority queue
    static ListNode betterSol(ListNode head) {
        if (head == null) return null;

        PriorityQueue<ListNode> pq =
                new PriorityQueue<>(Comparator.comparingInt(a -> a.data));

        ListNode temp = head;
        while (temp != null) {
            pq.add(temp);

            ListNode mover = temp.child;
            while (mover != null) {
                pq.add(mover);
                mover = mover.child;
            }
            temp = temp.next;
        }

        ListNode newHead = null;
        ListNode curr = null;

        while (!pq.isEmpty()) {
            ListNode node = pq.remove();

            node.next = null;

            if (newHead == null) {
                newHead = node;
                curr = node;
            } else {
                curr.child = node;
                curr = node;
            }
        }

        if (curr != null)
            curr.child = null;

        return newHead;
    }

    /// Using array
    static ListNode bruteSol(ListNode head) {
        if (head == null) return null;

        List<Integer> list = new ArrayList<>();

        ListNode temp = head;
        while (temp != null) {
            list.add(temp.data);

            ListNode mover = temp.child;
            while (mover != null) {
                list.add(mover.data);
                mover = mover.child;
            }

            temp = temp.next;
        }

        Collections.sort(list);

        ListNode newHead = new ListNode(list.getFirst());

        ListNode mover = newHead;
        for (int i = 1; i < list.size(); i++) {
            mover.child = new ListNode(list.get(i));
            mover = mover.child;
        }

        return newHead;
    }

    public static void main(String[] args) {
        ListNode head = convertToLinkedList();
        printLinkList(head);

        ListNode head1 = convertToLinkedList();
        ListNode head2 = convertToLinkedList();
        ListNode head3 = convertToLinkedList();

        printLinkList(flatten(head1));
        printLinkList(bruteSol(head2));
        printLinkList(betterSol(head3));
    }

    static ListNode convertToLinkedList() {

        ListNode n3 = new ListNode(3);
        ListNode n2 = new ListNode(2);
        ListNode n1 = new ListNode(1);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);

        // next links
        n3.next = n2;
        n2.next = n1;
        n1.next = n4;
        n4.next = n5;

        // child links
        n2.child = new ListNode(10);

        n1.child = new ListNode(7);
        n1.child.child = new ListNode(11);
        n1.child.child.child = new ListNode(12);

        n4.child = new ListNode(9);

        n5.child = new ListNode(6);
        n5.child.child = new ListNode(8);

        return n3;
    }

    static void printLinkList(ListNode head) {

        ListNode temp = head;

        while (temp != null) {

            System.out.print(temp.data);

            ListNode child = temp.child;

            while (child != null) {
                System.out.print(" -> " + child.data);
                child = child.child;
            }

            System.out.println();

            temp = temp.next;
        }
    }
}
