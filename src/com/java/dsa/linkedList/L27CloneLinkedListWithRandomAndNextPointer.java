package com.java.dsa.linkedList;

import static com.java.dsa.linkedList.Introduction.convertToLinkedList;
import static com.java.dsa.linkedList.Introduction.printLinkList;

public class L27CloneLinkedListWithRandomAndNextPointer {

//    static Node selfTry(Node head) {
//        if (head == null) return null;
//
//    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        Node head = convertToLinkedList(arr);
        printLinkList(head);
    }
}
