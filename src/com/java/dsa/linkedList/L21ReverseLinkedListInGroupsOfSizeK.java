package com.java.dsa.linkedList;

import static com.java.dsa.linkedList.Introduction.*;

public class L21ReverseLinkedListInGroupsOfSizeK {

    static Node getKthNode(Node temp, int k) {
        k--;

        while (temp != null && k > 0) {
            temp = temp.next;
            k--;
        }
        return temp;
    }

    static void reverseLinkedList(Node head) {
        Node prev = null;
        Node curr = head;

        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

    }

    static Node reverseKGroup(Node head, int k) {
        Node temp = head;
        Node prevLast = null;

        while (temp != null) {

            Node kthNode = getKthNode(temp, k);
            System.out.println(kthNode);
            if (kthNode == null) {
                if (prevLast != null)
                    prevLast.next = temp;
                break;
            }

            Node nextNode = kthNode.next;
            kthNode.next = null;

            reverseLinkedList(temp);

            if (temp == head) {
                head = kthNode;
            } else {
                prevLast.next = kthNode;
            }

            prevLast = temp;
            temp = nextNode;
        }

        return head;
    }
//    static Node selfTry(Node head, int k) {
//        if (head == null) return null;
//
//        int cnt = 0;
//        Node prevHead = head;
//
//        Node temp = head;
//        while (temp != null) {
//            cnt++;
//            if (cnt == k) {
//                Node next = temp.next;
//                temp.next = null;
//
//                Node newHead = reverse(prevHead);
//
//                prevHead.next = next;
//                if (prevHead == head)
//                    head = newHead;
//
//                cnt = 0;
//                prevHead = next;
//                temp = next;
//            } else {
//                temp = temp.next;
//            }
//        }
//        return head;
//    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        Node head = convertToLinkedList(arr);
        printLinkList(head);

        head = reverseKGroup(head, 3);
        printLinkList(head);

    }
}
