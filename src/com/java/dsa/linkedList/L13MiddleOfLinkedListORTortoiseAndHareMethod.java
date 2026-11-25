package com.java.dsa.linkedList;

import static com.java.dsa.linkedList.Introduction.convertToLinkedList;
import static com.java.dsa.linkedList.Introduction.printLinkList;

public class L13MiddleOfLinkedListORTortoiseAndHareMethod {


    /// Brute force is first count length of the Linked list
    /// then return the linked list
    static Node selfTry(Node head) {
        if (head == null) return null;

        int cnt = 0;

        Node midNode = head;
        Node temp = head;
        while (temp != null) {
            cnt++;
            if (cnt % 2 == 0) {
                midNode = midNode.next;
            }
            temp = temp.next;
        }
        return midNode;
    }

    static Node tortoiseAndHareMethod(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};

        Node head = convertToLinkedList(arr);
        printLinkList(head);

        System.out.println("Mid node value: " + selfTry(head).data);
        System.out.println("Mid node value: " + tortoiseAndHareMethod(head).data);
    }
}
