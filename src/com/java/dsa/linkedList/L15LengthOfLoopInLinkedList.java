package com.java.dsa.linkedList;

import java.util.HashMap;

import static com.java.dsa.linkedList.Introduction.*;

public class L15LengthOfLoopInLinkedList {

    static int usingHashing(Node head) {
        if (head == null) return 0;

        HashMap<Node, Integer> map = new HashMap<>();

        int cnt = 0;
        Node temp = head;

        while (temp != null) {

            if (map.containsKey(temp)) {
                return cnt - map.get(temp);
            }

            map.put(temp, cnt);
            cnt++;
            temp = temp.next;
        }

        return -1;
    }

    ///  Using Tortoise and More algorithm
    static int optimalSol(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                int cnt = 1;
                fast = fast.next;

                while (fast != slow) {
                    cnt++;
                    fast = fast.next;
                }

                return cnt;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 0, -4};

        Node head = convertToLinkedList(arr);
        printLinkList(head);

        makeCycle(head, 2);

        System.out.println("Ans: " + optimalSol(head));
        System.out.println("Ans: " + usingHashing(head));
    }
}
