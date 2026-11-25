package com.java.dsa.linkedList.doubly;

public class Introduction {

    static Node convertToLinkedList(int[] arr) {
        Node head = new Node(arr[0]);

        Node temp = head;
        for (int i = 1; i < arr.length; i++) {
            temp.next = new Node(arr[i], temp, null);
            temp = temp.next;
        }

        return head;
    }

    static void travel(Node head) {
        System.out.print("\nTraversing Linked List: ");
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.println("NULL\n");
    }

    static void printLinkList(Node head) {
        System.out.print("\nTraversing Linked List: ");
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.println("NULL\n");
    }

    static Node findTail(Node head) {
        if (head == null) return null;

        while (head.next != null) {
            head = head.next;
        }
        return head;
    }

    static void reverseTravel(Node head) {
        if (head == null) return;

        Node temp = findTail(head);

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.prev;
        }
        System.out.println("NULL\n");
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 5};
        Node head = convertToLinkedList(arr);

        travel(head);
        reverseTravel(head);
        System.out.println("Leaf is: " + findTail(head).data);
    }

}
