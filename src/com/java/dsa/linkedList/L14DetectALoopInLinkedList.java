package com.java.dsa.linkedList;

import static com.java.dsa.linkedList.Introduction.*;

public class L14DetectALoopInLinkedList {

    static boolean sol(Node head) {
        Node fast = head;
        Node slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (slow == fast) return true;
        }
        return false;
    }

    public static void main(String[] args) {

        int[] arr = {3, 2, 0, -4};

        Node head = convertToLinkedList(arr);
        printLinkList(head); // 12 5 6 7

        makeCycle(head, 1);

        System.out.println("Ans: " + sol(head));

    }
}
