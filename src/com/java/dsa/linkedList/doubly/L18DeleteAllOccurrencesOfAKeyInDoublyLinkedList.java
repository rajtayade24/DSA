package com.java.dsa.linkedList.doubly;

import static com.java.dsa.linkedList.doubly.Introduction.convertToLinkedList;
import static com.java.dsa.linkedList.doubly.Introduction.printLinkList;
import static com.java.dsa.linkedList.doubly.L2DeleteNode.deleteHead;

public class L18DeleteAllOccurrencesOfAKeyInDoublyLinkedList {

    static Node deleteAllOccurOfX(Node head, int target) {
        Node temp = head;

        while (temp != null) {
            if (temp.data == target) {
                if (temp == head) { // Update head if needed
                    head = head.next;
                }
                Node nextNode = temp.next;
                Node prevNode = temp.prev;

                if (prevNode != null) prevNode.next = nextNode;
                if (nextNode != null) nextNode.prev = prevNode;

                temp = nextNode;
            } else {
                temp = temp.next;
            }
        }

        return head;
    }

    static Node selfTry(Node head, int target) {
        while (head != null && head.data == target) {
            head = deleteHead(head);
        }
        if (head == null) return null;

        Node temp = head;
        while (temp != null) {
            if (temp.data == target) {
                Node prev = temp.prev;
                Node next = temp.next;

                prev.next = next;
                if (next != null)
                    next.prev = prev;
            }
            temp = temp.next;
        }

        return head;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1, 4};
        Node head = convertToLinkedList(arr);

        printLinkList(head);

        head = deleteAllOccurOfX(head, 1);
        printLinkList(head);

    }
}
