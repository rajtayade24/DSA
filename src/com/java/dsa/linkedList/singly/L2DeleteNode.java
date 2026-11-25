package com.java.dsa.linkedList.singly;

import static com.java.dsa.linkedList.singly.L1Introduction.convertToLinkedList;
import static com.java.dsa.linkedList.singly.L1Introduction.printLinkList;

public class L2DeleteNode {

    static Node deleteHead(Node head) {
        return (head == null) ? null : head.next;
    }

    static Node deleteTail(Node head) {
        if (head == null || head.next == null)
            return null;

        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;

        return head;
    }

    static Node deleteByData(Node head, int target)  {
        if (head == null) return null;

        if (head.data == target) {
            return deleteHead(head);
        }

        Node temp = head;
        Node prev = null;
        while (temp != null && temp.data != target) {
            prev = temp;
            temp = temp.next;
        }

        // If target is not found
        if (temp == null) {
            System.out.println("Target data " + target + " is not found");
            return head;
        }

        prev.next = temp.next;
        return head;
    }

    public static void main(String[] args)  {
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
