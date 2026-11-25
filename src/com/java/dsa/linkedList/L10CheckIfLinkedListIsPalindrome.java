package com.java.dsa.linkedList;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

import static com.java.dsa.linkedList.Introduction.*;

public class L10CheckIfLinkedListIsPalindrome {

    static boolean usingArray(Node head) {
        List<Integer> list = new ArrayList<>();

        Node temp = head;
        while (temp != null) {
            list.add(temp.data);
            temp = temp.next;
        }

        int left = 0, right = list.size() - 1;
        while (left <= right) {
            if (!Objects.equals(list.get(left), list.get(right)))
                return false;
            left++;
            right--;
        }
        return true;
    }

    static boolean usingStack(Node head) {
        Stack<Integer> stack = new Stack<>();

        Node temp = head;

        // Push all elements into stack
        while (temp != null) {
            stack.push(temp.data);
            temp = temp.next;
        }

        temp = head;

        // Compare linked list values with stack values
        while (temp != null) {
            if (temp.data != stack.pop())
                return false;

            temp = temp.next;
        }

        return true;
    }

    static boolean optimalSol(Node head) {
        if (head == null || head.next == null) return true;

        Node fast = head;
        Node slow = head;

//        while (fast != null && fast.next != null) { // For an even-length list, slow reaches the first node of the second half.
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node newHead = reverse(slow.next);

        Node left = head, right = newHead;
        while (right != null) {
            if (left.data != right.data) {
                reverse(newHead);
                return false;
            }

            left = left.next;
            right = right.next;
        }

        reverse(newHead);

        return true;
    }

    static Node reverse(Node head) {
        Node temp = head;
        Node prev = null;

        while (temp != null) {
            Node next = temp.next; // store next

            temp.next = prev; // reverse link

            prev = temp; // move prev
            temp = next; // move temp
        }

        return prev; // new head
    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 3, 2, 1};

        Node head = convertToLinkedList(arr);
        printLinkList(head);

        if (optimalSol(head))
            System.out.println("Yes the Linked list is palindrome");
        else
            System.out.println("No the Linked list is not palindrome");
    }
}
