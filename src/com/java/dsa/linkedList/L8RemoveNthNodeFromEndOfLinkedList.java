package com.java.dsa.linkedList;

import static com.java.dsa.linkedList.Introduction.convertToLinkedList;
import static com.java.dsa.linkedList.Introduction.printLinkList;

public class L8RemoveNthNodeFromEndOfLinkedList {

    static Node selfTry(Node head, int n) {
        if (head == null) return null;

        int len = 0;
        Node temp = head;
        while (temp != null) {
            len++;
            temp = temp.next;
        }

        if (len == n)  // node is head
            return head.next;

        temp = head;
        int cnt = 0;
        while (temp != null) {
            cnt++;
            if (len - n == cnt) {
                temp.next = temp.next.next;
                break; // deletion done
            }
            temp = temp.next;
        }
        return head;
    }

    static Node optimalSol(Node head, int n) {
        if (head == null) return null;

        int cnt = 0;
        Node targetNode = head;
        Node temp = head;

        while (temp != null) {
            if (cnt > n)
                targetNode = targetNode.next;

            cnt++;
            temp = temp.next;
        }
        if (cnt == n) return head.next;
        if (cnt < n) return head; // invalid n

        targetNode.next = targetNode.next.next;
        return head;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};

        Node head = convertToLinkedList(arr);
        printLinkList(head);

        head = optimalSol(head, 1);
        printLinkList(head);
    }
}
