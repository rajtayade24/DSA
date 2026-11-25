package com.java.dsa.stackAndQueue.stack;

public class UsingArray {
    private static final int MAX_SIZE = 10;

    private final int[] stack = new int[MAX_SIZE];
    private int top;

    UsingArray() {
        top = -1;
    }

    boolean isEmpty() {
        return top == -1;
    }

    boolean isFull() {
        return top == MAX_SIZE - 1;
    }

    void push(int n) {
        if (isFull()) {
            System.out.println("Stack Overflow!\n");
            return;
        }
        stack[++top] = n;
        System.out.println(n + " pushed");
    }

    void pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow!\n");
            return;
        }
        System.out.println(stack[top--] + " popped");
    }

    int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return -1;
        }
        return stack[top];
    }

    void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return;
        }

        System.out.println("\nStack: ");
        for (int i = top; i >= 0; i--) {
            System.out.print(stack[i] + " ");
        }
        System.out.println("\n");
    }

    int size() {
        return top + 1;
    }

    void clear() {
        top = -1;
        System.out.println("Stack cleared");
    }

    public static void main(String[] args) {
        UsingArray s = new UsingArray();
        s.push(10);
        s.push(20);
        s.push(30);

        s.display();

        s.pop();
        s.pop();
        s.pop();
        s.pop();
    }
}
