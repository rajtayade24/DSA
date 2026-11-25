package com.java.dsa.linkedList.doubly;

import java.util.Scanner;

import static com.java.dsa.linkedList.doubly.Introduction.convertToLinkedList;
import static com.java.dsa.linkedList.doubly.Introduction.printLinkList;

public class L2InsertNode {

    static Node insertAtHead(Node head, int value) {
        Node newNode = new Node(value, null, head);

        if (head != null)
            head.prev = newNode;

        return newNode;
    }

    static Node insertAtTail(Node head, int value) {
        if (head == null) return new Node(value);

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = new Node(value, temp, null);
        return head;
    }

    static Node insertAtPosition(Node head, int value, int k) {
        if (k <= 0) {
            System.out.println("Invalid position");
            return head;
        }

        if (k == 1)
            return insertAtHead(head, value);

        Node temp = head;
        int cnt = 1;

        while (temp != null && cnt < k - 1) {
            temp = temp.next;
            cnt++;
        }

        if (temp == null) {
            System.out.println("Position does not exist");
            return head;
        }

        Node newNode = new Node(value, temp, temp.next);

        if (temp.next != null)
            temp.next.prev = newNode;

        temp.next = newNode;

        return head;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 5};
        Node head = convertToLinkedList(arr);

        System.out.print("\nLinkedList created: ");
        printLinkList(head);

        int el;
        Scanner sc = new Scanner(System.in);

        System.out.print("enter element to insert at head: ");
        el = sc.nextInt();
        head = insertAtHead(head, el);
        printLinkList(head);

        System.out.print("Enter element to insert at tail: ");
        el = sc.nextInt();
        head = insertAtTail(head, el);
        printLinkList(head);

        int pos = 3;
        System.out.print("Enter element to insert at position " + pos + ": ");
        el = sc.nextInt();
        head = insertAtPosition(head, el, pos);
        printLinkList(head);

//        int val = 2;
//        System.out.print("Enter element to insert before value:  " + val + ": ");
//        el = sc.nextInt();
//        head = insertBeforeValue(head, el, val);
//        printLinkList(head);
    }
}
