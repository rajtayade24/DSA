package com.java.dsa.linkedList;

import java.util.ArrayList;
import java.util.List;

import static com.java.dsa.linkedList.Introduction.convertToLinkedList;
import static com.java.dsa.linkedList.Introduction.printLinkList;

public class L6SegregateOddAndEvenNodesInLinkedList {

    static void swapData(Node left, Node right) {
        int tempData = left.data;
        left.data = right.data;
        right.data = tempData;
    }

    static Node bruteSol(Node head) {
        if (head == null || head.next == null) return head;

        List<Integer> arr = new ArrayList<>();

        Node odd = head;
        while (odd != null && odd.next != null) {
            arr.add(odd.data);
            odd = odd.next.next;
        }

        Node even = head.next;
        while (even != null && even.next != null) {
            arr.add(even.data);
            even = even.next.next;
        }

        Node temp = head;
        for (int i = 0; i < arr.size(); i++) {
            temp.data = arr.get(i);
            temp = temp.next;
        }

        return head;
    }

    static Node optimalSol(Node head) {
        if (head == null || head.next == null)
            return head;

        Node odd = head;
        Node even = head.next;
        Node evenHead = even;

        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;

            odd = odd.next;
            even = even.next;
        }

        odd.next = evenHead;

        return head;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};

        Node head = convertToLinkedList(arr);
        printLinkList(head);

        head = optimalSol(head);
        printLinkList(head);
    }
}
