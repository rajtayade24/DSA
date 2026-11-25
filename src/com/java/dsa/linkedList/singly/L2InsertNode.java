package com.java.dsa.linkedList.singly;

import java.util.Scanner;
import static com.java.dsa.linkedList.singly.L1Introduction.convertToLinkedList;
import static com.java.dsa.linkedList.singly.L1Introduction.printLinkList;

public class L2InsertNode {

    static Node insertAtHead(Node head, int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        return newNode;
    }

    static Node insertAtTail(Node head, int data) {
        Node newNode = new Node(data);

        if (head == null) return newNode;

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        return head;
    }

    static Node insertAtPosition(Node head, int data, int k) {
        if (k <= 0) {
            System.out.println("Invalid position");
            return head;
        }

        if (k == 1)
            return insertAtHead(head, data);

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

        Node newNode = new Node(data);
        newNode.next = temp.next;
        temp.next = newNode;

        return head;
    }

    static Node insertBeforeValue(Node head, int data, int val) {
        if (head == null) return null;

        if (head.data == val)
            return insertAtHead(head, data);

        Node temp = head;
        while (temp.next != null && temp.next.data != val) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Value " + val + " not found");
            return head;
        }

        Node newNode = new Node(data);
        newNode.next = temp.next;
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

        int val = 2;
        System.out.print("Enter element to insert before value:  " + val + ": ");
        el = sc.nextInt();
        head = insertBeforeValue(head, el, val);
        printLinkList(head);
    }
}