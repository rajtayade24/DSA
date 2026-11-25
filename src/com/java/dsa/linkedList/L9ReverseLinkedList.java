package com.java.dsa.linkedList;

import java.util.Stack;

import static com.java.dsa.linkedList.Introduction.*;

public class L9ReverseLinkedList {

    static Node bruteSol(Node head) {
        Stack<Integer> stack = new Stack<>();

        Node temp = head;
        // Store all node values
        while (temp != null) {
            stack.push(temp.data);
            temp = temp.next;
        }

        // Replace values in reverse order
        temp = head;
        while (temp != null) {
            temp.data = stack.pop();
            temp = temp.next;
        }

        return head;
    }

    //    1. Iterative Solution:
    //  Both solutions have the same time complexity, but the iterative solution is generally considered more optimal.
    static Node reverseLinkedList(Node head) {
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


    //    2. Recursive Solution
    static Node reverse(Node head) {
        if (head == null || head.next == null)
            return head;

        Node newHead = reverse(head.next);
        Node front = head.next;
        front.next = head;
        head.next = null;

        return newHead;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};

        Node head = convertToLinkedList(arr);
        printLinkList(head); // 12 5 6 7

        head = reverseLinkedList(head);
        printLinkList(head); // 7 6 5 12
    }

}

/// 1. Iterative Solution

//  Complexity
//Time: O(n)
//Space: O(1)

//  ADVANTAGES
//✅ No extra memory used
//✅ No risk of stack overflow
//✅ Faster in practice (no recursive function call overhead)

/// 2. Recursive Solution

//  Complexity
//Time: O(n)
//Space: O(n) (due to recursion call stack)

//  ADVANTAGES
//✅ Elegant and shorter
//✅ Good for understanding recursion

//  DISADVANTAGES
//❌ Uses extra stack memory
//❌ Can cause StackOverflowError for very large linked lists
