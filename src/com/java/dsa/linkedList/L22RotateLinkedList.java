package com.java.dsa.linkedList;

import static com.java.dsa.linkedList.Introduction.*;

public class L22RotateLinkedList {

    static Node getSecondLastNode(Node head) {
        if (head == null || head.next == null)
            return null;

        Node temp = head;
        while (temp.next != null && temp.next.next != null) {
            temp = temp.next;
        }
        return temp;
    }

    static Node bruteSol(Node head, int k) {
        if (head == null) return null;

        int len = findLength(head);
        k = k % len;

        while (k > 0) {
            Node secondLastNode = getSecondLastNode(head);
            Node tail = secondLastNode.next;

            secondLastNode.next = null;
            tail.next = head;
            head = tail;
            k--;
        }
        return head;
    }

    ///  Optimal solution
    static Node rotateRight(Node head, int k) {
        if (head == null || head.next == null || k == 0)
            return head;

        // Find length and tail
        Node tail = head;
        int len = 1;
        while (tail.next != null) {
            tail = tail.next;
            len++;
        }

        k = k % len;
        if (k == 0)
            return head;

        tail.next = head; // Make circular LL

        int stepsToNewTail = len - k;
        Node newTail = head;

        for (int i = 1; i < stepsToNewTail; i++) {
            newTail = newTail.next;
        }

        Node newHead = newTail.next;

        newTail.next = null; // Break the circle

        return newHead;
    }

    ///    This code cause null pointer exception when k=0
    static Node betterSol(Node head, int k) {
        if (head == null) return null;

        int len = findLength(head);
        k = k % len;

        int cnt = len - k;
        Node temp = head;
        while (temp != null && cnt > 1) {
            temp = temp.next;
            cnt--;
        }

        Node newHead = temp.next; // null pointer exception when k=0
        temp.next = null;

        temp = newHead;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = head;

        return newHead;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        Node head = convertToLinkedList(arr);
        printLinkList(head);

        head = bruteSol(head, 2);
        printLinkList(head);

        head = rotateRight(head, 2);
        printLinkList(head);
    }
}
