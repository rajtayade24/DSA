package com.java.dsa.linkedList;

import static com.java.dsa.linkedList.Introduction.convertToLinkedList;
import static com.java.dsa.linkedList.Introduction.printLinkList;

public class L11AddOneToANumberRepresentedByLinkedList {

    static Node reverseLinkedList(Node head) {
        Node temp = head;
        Node prev = null;

        while (temp != null) {
            Node next = temp.next; // store next

            temp.next = prev; // reverse link

            prev = temp; // move prev
            temp = next; // move temp
        }

        return prev; // new head
    }

    static Node selfTry(Node head) {
        if (head == null) return null;

        Node newHead = reverseLinkedList(head);

        int carry = 0;
        Node temp = newHead;
        while (temp != null) {
            if (temp.data + carry < 9) {
                temp.data++;
                break;
            }

            temp.data = 0;
            carry = 1;
            temp = temp.next;
        }
        head = reverseLinkedList(newHead);

        if (carry != 0) {
            Node newNode = new Node(carry);
            newNode.next = head;
            return newNode;
        }
        return head;
    }

    static Node betterVersion(Node head) {
        if (head == null) return null;

        Node newHead = reverseLinkedList(head);

        int carry = 1;
        Node temp = newHead;

        while (temp != null && carry > 0) {
            int sum = temp.data + carry;
            temp.data = sum % 10;
            carry = sum / 10;

            if (temp.next == null && carry > 0) {
                temp.next = new Node(carry);
                carry = 0;
            }

            temp = temp.next;
        }

        return reverseLinkedList(newHead);
    }

    static int recursion(Node head) {
        if (head == null) return 1; // initial carry = 1

        int carry = recursion(head.next);

        if(carry==0) return 0;
        int sum = head.data + carry;
        head.data = sum % 10;

        return sum / 10;
    }

    static Node usingRecursion(Node head) {
        int carry = recursion(head);

        if (carry > 0) {
            Node newNode = new Node(carry);
            newNode.next = head;
            return newNode;
        }

        return head;
    }

    public static void main(String[] args) {
        int[] arr = {9, 9, 9};

        Node head = convertToLinkedList(arr);
        printLinkList(head); // 12 5 6 7

        head = selfTry(head);
        printLinkList(head);

        head = betterVersion(head);
        printLinkList(head);

        head = usingRecursion(head);
        printLinkList(head);
    }
}
