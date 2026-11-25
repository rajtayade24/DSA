package com.java.dsa.linkedList;

import static com.java.dsa.linkedList.Introduction.*;

public class LeetCodeDeleteDuplicates {

    static Node selfTry(Node head) {
        if (head == null) return null;

        Node temp = head;
        while (temp.next != null) {
            if (temp.data == temp.next.data) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 1, 1, 3, 4, 4, 5};
        Node head = convertToLinkedList(arr);
        printLinkList(head);

        head = selfTry(head);
        printLinkList(head);

    }
}
