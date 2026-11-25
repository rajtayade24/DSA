package com.java.dsa.linkedList.doubly;

import static com.java.dsa.linkedList.doubly.Introduction.convertToLinkedList;
import static com.java.dsa.linkedList.doubly.Introduction.printLinkList;

public class L20RemoveDuplicatesFromSortedDoublyLinkedList {

    static Node removeDuplicates(Node head) {
        if (head == null) return null;

        Node temp = head;

        while (temp.next != null) {
            if (temp.data == temp.next.data) {
                Node nextNode = temp.next.next;

                temp.next = nextNode;

                if (nextNode != null) {
                    nextNode.prev = temp;
                }
            } else {
                temp = temp.next;
            }
        }
        return head;
    }

    static Node selfTry(Node head) {
        if (head == null || head.next == null) return head;

        Node first = head;
        Node second = head.next;

        while (second != null) {
            if (first.data == second.data) {
                Node nextNode = second.next;

                first.next = nextNode;
                if (nextNode != null)
                    nextNode.prev = first;

                second = nextNode;
            } else {
                first = second;
                second = second.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 1, 1, 3, 4, 4, 5};
        Node head = convertToLinkedList(arr);
        printLinkList(head);

        head = removeDuplicates(head);
        printLinkList(head);

    }

}
