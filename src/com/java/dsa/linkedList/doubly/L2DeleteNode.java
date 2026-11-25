package com.java.dsa.linkedList.doubly;

import static com.java.dsa.linkedList.doubly.Introduction.convertToLinkedList;
import static com.java.dsa.linkedList.doubly.Introduction.printLinkList;

public class L2DeleteNode {

    static Node deleteHead(Node head) {
        if (head == null || head.next == null)
            return null;

        Node temp = head.next;

        temp.prev = null; // Free memory
        head.next = null;

        return temp;
    }

    static Node deleteTail(Node head) {
        if (head == null || head.next == null)
            return null;

        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }

        temp.next.prev = null; // Free memory
        temp.next = null;

        return head;
    }

    static Node deleteByData(Node head, int value) {
        if (head == null) return null;

        if (head.data == value) {
            return deleteHead(head);
        }

        Node temp = head;
        while (temp != null && temp.data != value) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Target data " + value + " is not found");
            return head;
        }

        temp.prev.next = temp.next;
        if (temp.next != null)
            temp.next.prev = temp.prev;

        temp.prev = null;
        temp.next = null;  // Free memory
        return head;
    }

    public static void main(String[] args) {
        int[] arr = {12, 4, 6, 7};
        Node head = convertToLinkedList(arr);

        System.out.print("\nLinkedList created: ");
        printLinkList(head);

        head = deleteHead(head);
        System.out.print("After deleting head: ");
        printLinkList(head);

        head = deleteTail(head);
        System.out.print("After deleting tail: ");
        printLinkList(head);

        int target = 12;
        head = deleteByData(head, target);
        printLinkList(head);
    }
}
