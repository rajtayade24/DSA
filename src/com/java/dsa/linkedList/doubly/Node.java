package com.java.dsa.linkedList.doubly;

public class Node {
    int data;
    Node prev;
    Node next;

    Node(int d) {
        data = d;
        next = null;
        prev = null;
    }

    Node(int d, Node left, Node right) {
        data = d;
        prev = left;
        next = right;
    }

};