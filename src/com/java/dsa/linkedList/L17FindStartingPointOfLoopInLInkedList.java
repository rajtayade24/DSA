package com.java.dsa.linkedList;

import java.util.HashSet;

import static com.java.dsa.linkedList.Introduction.*;

public class L17FindStartingPointOfLoopInLInkedList {

    static Node usingHashing(Node head) {
        if (head == null) return null;

        HashSet<Node> set = new HashSet<>();

        Node temp = head;

        while (temp != null) {

            if (set.contains(temp)) {
                return temp;
            }
            set.add(temp);
            temp = temp.next;
        }

        return null;
    }


    /// Using Tortoise and Hare algorithm
    static Node optimalSol(Node head) {
        if (head == null|| head.next== null) return null;

        Node fast = head;
        Node slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (slow == fast) {
                Node temp = head;

                while (temp != slow) {
                    slow = slow.next;
                    temp = temp.next;
                }

                return temp;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 0, -4};

        Node head = convertToLinkedList(arr);
        printLinkList(head); // 12 5 6 7

        makeCycle(head, 1);

        Node ans = optimalSol(head);

        if (ans != null)
            System.out.println("Ans: " + ans.data);
        else
            System.out.println("No cycle");
    }
}
