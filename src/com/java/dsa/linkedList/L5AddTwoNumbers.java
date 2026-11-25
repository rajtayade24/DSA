package com.java.dsa.linkedList;

import static com.java.dsa.linkedList.Introduction.convertToLinkedList;
import static com.java.dsa.linkedList.Introduction.printLinkList;

public class L5AddTwoNumbers {

    static Node solfTry(Node h1, Node h2) {
        if (h1 == null || h2 == null) return h1 == null ? h2 : h1;

        Node dummyNode = new Node(-1);

        Node t1 = h1, t2 = h2;
        Node temp = dummyNode;
        int carry = 0;
        while (t1 != null || t2 != null) {
            int sum = carry;
            if (t1 != null) sum += t1.data;
            if (t2 != null) sum += t2.data;

            temp.next = new Node(sum % 10);
            carry = sum / 10;

            temp = temp.next;
            if (t1 != null) t1 = t1.next;
            if (t2 != null) t2 = t2.next;
        }
        if (carry != 0) {
            temp.next = new Node(carry);
        }
        return dummyNode.next;
    }

    public static void main(String[] args) {

        int[] l1 = {2, 4, 3};
        int[] l2 = {5, 6, 4};

        Node h1 = convertToLinkedList(l1);
        Node h2 = convertToLinkedList(l2);
        printLinkList(h1);
        printLinkList(h2);

        Node dummyNode = solfTry(h1, h2);
        printLinkList(dummyNode);

    }
}
