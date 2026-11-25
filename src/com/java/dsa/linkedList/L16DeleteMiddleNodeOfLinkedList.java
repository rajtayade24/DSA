package com.java.dsa.linkedList;

import static com.java.dsa.linkedList.Introduction.convertToLinkedList;
import static com.java.dsa.linkedList.Introduction.printLinkList;

public class L16DeleteMiddleNodeOfLinkedList {

    static Node deleteMiddle(Node head) {
        if (head == null || head.next == null)
            return null;

        Node slow = head;
        Node fast = head.next.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        slow.next = slow.next.next;

        return head;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};

        Node head = convertToLinkedList(arr);
        printLinkList(head);

        head = deleteMiddle(head);
        printLinkList(head);
    }


}
