package com.java.dsa.stackAndQueue.queue;

public class UsingLinkedList {
    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    private Node front;
    private Node rear;
    private int size;

    boolean isEmpty() {
        return front == null;
    }

    void enqueue(int n) {
        Node newNode = new Node(n);

        if (isEmpty()) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;

        System.out.println(n + " enqueued");
    }

    void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Underflow!");
            return;
        }
        size--;

        System.out.println(front.data + " dequeued");

        front = front.next;
        if (front == null) {
            rear = null;
        }
    }

    int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty!!!");
            return -1;
        }
        return front.data;
    }

    void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty!!!");
            return;
        }
        Node temp = front;
        System.out.println("\nQueue: ");
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
        front = rear = null;
        size = 0;
    }

    public static void main(String[] args) {
        UsingLinkedList q = new UsingLinkedList();
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);

        q.display();

        q.dequeue();

        q.display();
    }
}
