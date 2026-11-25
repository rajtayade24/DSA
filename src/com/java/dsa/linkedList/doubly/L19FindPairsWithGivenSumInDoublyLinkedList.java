package com.java.dsa.linkedList.doubly;

import java.util.*;

import static com.java.dsa.linkedList.doubly.Introduction.*;

public class L19FindPairsWithGivenSumInDoublyLinkedList {

    static List<List<Integer>> selfTry(Node head, int k) {
        if (head == null) return null;

        List<List<Integer>> list = new ArrayList<>();

        Node temp = head;
        Node tail = findTail(head);
        while (temp != tail) {
            int a = temp.data, b = tail.data;
            int sum = a + b;

            if (sum == k) {
                list.add(Arrays.asList(a, b));
                temp = temp.next;
                tail = tail.prev;
            } else if (sum < k)
                temp = temp.next;
            else
                tail = tail.prev;
        }

        return list;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5, 6, 8, 9};
        Node head = convertToLinkedList(arr);

        printLinkList(head);

        System.out.println(selfTry(head, 7));

    }
}
