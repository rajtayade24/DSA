package com.java.dsa;

import com.java.dsa.linkedList.Node;

public class LC21MergeTwoSortedLists {

    static Node selfTry(Node list1, Node list2) {

        Node t1 = list1;
        Node t2 = list2;

        Node dummy = new Node(-1);
        Node temp = dummy;

        while (t1 != null && t2 != null) {
            if (t1.data < t2.data) {
                temp.next = t1;
                t1 = t1.next;
            } else {
                temp.next = t2;
                t2 = t2.next;
            }
            temp = temp.next;
        }

        while (t1 != null) {
            temp.next = t1;
            t1 = t1.next;
            temp = temp.next;
        }
        while (t2 != null) {
            temp.next = t2;
            t2 = t2.next;
            temp = temp.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        // List 1: 1 -> 2 -> 4
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(4);

        // List 2: 1 -> 3 -> 4
        Node head2 = new Node(1);
        head2.next = new Node(3);
        head2.next.next = new Node(4);

    }
}
