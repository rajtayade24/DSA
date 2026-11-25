package com.java.dsa.linkedList.singly;

public class L1Introduction {

    static Node convertToLinkedList(int[] arr) {
        Node head = new Node(arr[0]);

        Node mover = head;
        for (int i = 1; i < arr.length; i++) {
            mover.next = new Node(arr[i]);
            mover = mover.next;
        }
        return head;
    }

    static void printLinkList(Node head) {
        System.out.print("\nTraversing Linked List: ");
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next; // values
        }
        System.out.println("NULL\n");
    }

    static int lengthOfLinkedList(Node head) {
        int cnt = 0;
        Node mover = head;
        while (mover != null) {
            mover = mover.next;
            cnt++;
        }
        return cnt;
    }

    static boolean checkIfPresent(Node head, int val) {
        Node mover = head;
        while (mover != null) {
            if (mover.data == val) return true;
            mover = mover.next;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {12, 4, 6, 7};
        Node head = convertToLinkedList(arr);

        printLinkList(head);

        System.out.print("Addresses: ");
        Node temp1 = head;
        while (temp1 != null) {
            System.out.print(temp1.next + " -> ");
            temp1 = temp1.next; //addreses
        }

        System.out.println("Length of linked list: " + lengthOfLinkedList(head));
        System.out.println("present in linked list: " + checkIfPresent(head, 5));
    }
}
