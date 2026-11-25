package com.java.dsa.stackAndQueue.queue;

public class UsingArray {
    private static final int MAX_SIZE = 10;

    private final int[] queue = new int[MAX_SIZE];
    private int front;
    private int rear;

    UsingArray() {
        front = -1;
        rear = -1;
    }

    boolean isEmpty() {
        return front == -1;
    }

    boolean isFull() {
        return (rear == MAX_SIZE - 1);
    }


    void enqueue(int n) {
        if (isFull()) {
            System.out.println("Queue Overflow!");
            return;
        }

        // First element being inserted
        if (front == -1) {
            front = 0;
        }

        rear++;
        queue[rear] = n;
        System.out.println(n + " enqueued");
    }

    void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Underflow!");
            return;
        }

        System.out.println(queue[front] + " dequeued");

        if (front == rear) {
            front = rear = -1;
        } else {
            front++;
        }
    }

    int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            ;
            return -1;
        }
        return queue[front];
    }

    int size() {
        if (isEmpty()) return 0;
        return (rear - front + 1);
    }

    void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            ;
            return;
        }

        System.out.println("\nQueue elements: ");
        for (int i = front; i <= rear; i++) {
            System.out.print(queue[i] + " ");
        }
        System.out.println("\n");
    }

    void clear() {
        front = -1;
        rear = -1;
        System.out.println("Queue cleared\n");
    }

    public static void main(String[] args) {
        UsingArray q = new UsingArray();

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);

        q.display();

        q.dequeue();
        q.dequeue();
        q.dequeue();
        q.dequeue();  // underflow
    }
}
