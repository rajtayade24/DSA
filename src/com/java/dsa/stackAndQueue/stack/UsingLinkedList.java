package com.java.dsa.stackAndQueue.stack;

public class UsingLinkedList {
    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    private Node top;
    private int size;

    boolean isEmpty() {
        return top == null;
    }

    void push(int n) {
        Node newNode = new Node(n);
        newNode.next = top;  // link old top
        top = newNode;        // new node becomes top
        size++;
        System.out.println(n + " pushed");
    }

    void pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow!");
            return;
        }
        size--;
        System.out.println(top.data + " popped");
        top = top.next;
    }

    int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return -1;
        }
        return top.data;
    }

    void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return;
        }
        Node temp = top;
        System.out.println("\nStack elements: ");
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println("\n");
    }

    int size() {
        return size;
    }

    void clear() {
        top = null;
        size = 0;
        System.out.println("Stack cleared");
    }

    public static void main(String[] args) {
        UsingLinkedList s = new UsingLinkedList();
        s.push(10);
        s.push(20);
        s.push(30);

        s.display();

        s.pop();

        s.display();
    }
}
