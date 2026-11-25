package com.java.dsa.linkedList;

import static com.java.dsa.linkedList.Introduction.*;

public class L26SortLinkedList {

    static void swapData(Node left, Node right) {
        int tempData = left.data;
        left.data = right.data;
        right.data = tempData;
    }

    static Node selfTry(Node head) {
        if (head == null) return null;

        int len = findLength(head);

        for (int i = 0; i < len; i++) {
            Node temp = head;
            while (temp != null && temp.next != null) {
                if (temp.data > temp.next.data)
                    swapData(temp, temp.next);
                temp = temp.next;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        int[] arr = {4, 3, 5, 7, 6, 2, 9};

        Node head = convertToLinkedList(arr);
        printLinkList(head);

        head = selfTry(head);
        printLinkList(head);
    }
}
