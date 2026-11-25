package com.java.dsa.linkedList;

public class Introduction {

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
        System.out.println("NULL");
    }

        static int findLength(Node head) {
            int cnt = 0;
            while (head != null) {
                head = head.next;
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

    static Node findTail(Node head) {
        if (head == null) return null;

        while (head.next != null) {
            head = head.next;
        }
        return head;
    }

    static Node findMiddle(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    static void makeCycle(Node head, int pos) {
        if (head == null) return;

        Node temp = head;
        int cnt = 0;

        while (temp != null && cnt < pos) {
            temp = temp.next;
            cnt++;
        }

        if (temp == null) return; // invalid position

        findTail(head).next = temp;
    }

    public static void main(String[] args) {
        int[] arr = {12, 4, 6, 7};
        Node head = convertToLinkedList(arr);

        printLinkList(head);

        System.out.print("Addresses: ");
        Node temp1 = head;
        while (temp1 != null) {
            System.out.print(temp1.next + " -> ");
            temp1 = temp1.next; // addresses
        }

        System.out.println("Length of linked list: " + findLength(head));
        System.out.println("present in linked list: " + checkIfPresent(head, 5));
    }
}
