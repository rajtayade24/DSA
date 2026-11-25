package com.java.dsa.linkedList;

import java.util.HashSet;

import static com.java.dsa.linkedList.Introduction.*;

public class L12FindIntersectionOfTwoLinkedLists {

    static Node selfTry(Node headA, Node headB) {
        Node first = headA;

        while (first != null) {
            Node second = headB;
            while (second != null) {
                if (first == second) return first;
                second = second.next;
            }
            first = first.next;
        }
        return null;
    }

    //    Time Complexity: O(N + M)
//    Space Complexity: O(N)
    static Node usingHashSet(Node headA, Node headB) {
        if (headA == null || headB == null) return null;

        HashSet<Node> set = new HashSet<>();

        Node first = headA;
        Node second = headB;
        while (first != null) {
            set.add(first);
            first = first.next;
        }

        while (second != null) {
//    This works because Node does not override equals() and hashCode(). Is effectively checking reference equality (similar to ==)
            if (set.contains(second)) return second;
            second = second.next;
        }
        return null;
    }
//    What HashSet actually does?
//    A HashSet uses a hash function to directly determine where an object should be stored.
//
//    Imagine a set with buckets:
//    Bucket 0 -> ...
//    Bucket 1 -> Node(5)
//    Bucket 2 -> Node(8)
//    Bucket 3 -> Node(6)
//    Bucket 4 -> ...
//
//    When you do: set.add(node8);
//
//    Java computes: hash = node8.hashCode();
//    and places the node into the corresponding bucket.
//
//    Later: set.contains(node8); Java computes the same hash and jumps directly to that bucket instead of checking every element.
//
//    contains(node8)
//      ↓
//    hashCode()
//      ↓
//    Bucket 2
//      ↓
//    Found

//    So average time is O(1).

    static Node helper(Node head, int diff) {
        while (diff-- > 0) head = head.next;
        return head;
    }

    //    Length difference method
    static Node usingLengthdifferenceMethod(Node headA, Node headB) {
        int lenA = findLength(headA);
        int lenB = findLength(headB);

        Node first = headA, second = headB;
        if (lenA > lenB) {
            first = helper(headA, lenA - lenB);
        } else {
            second = helper(headB, lenB - lenA);
        }

        while (first != null && second != null) {
            if (first == second) return first;
            first = first.next;
            second = second.next;
        }
        return null;
    }

    //    Two-pointer switching method
    static Node usingTwoPointerSwitchingMethod(Node headA, Node headB) {
        Node first = headA;
        Node second = headB;

        while (first != second) {
            first = (first == null) ? headB : first.next;
            second = (second == null) ? headA : second.next;
        }

        return first;
    }

    public static void main(String[] args) {
        int[] arr1 = {5, 6, 8, 4, 5};
        int[] arr2 = {2, 4};

        Node headA = convertToLinkedList(arr1);
        printLinkList(headA);

        Node headB = convertToLinkedList(arr2);

        Node tailB = findTail(headB);
        tailB.next = headA.next.next;

        printLinkList(headB);

        Node targetNode = usingTwoPointerSwitchingMethod(headA, headB);

        if (targetNode == null)
            System.out.println("\nThere is no intersection in the LL");
        else
            System.out.println("Intersection is at: " + targetNode.data);
    }
}
