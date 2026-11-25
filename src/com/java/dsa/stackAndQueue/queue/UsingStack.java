package com.java.dsa.stackAndQueue.queue;

import java.util.Stack;

class MyQueue {

    Stack<Integer> stack;
    Stack<Integer> copy;

    public MyQueue() {
        stack = new Stack<>();
        copy = new Stack<>();
    }

    public void push(int x) {
        while (!stack.isEmpty()) {
            copy.push(stack.pop());
        }

        copy.push(x);

        while (!copy.isEmpty()) {
            stack.push(copy.pop());
        }
    }

    public int pop() {
        return stack.pop();
    }

    public int peek() {
        return stack.peek();
    }

    public boolean empty() {
        return stack.isEmpty();
    }
}

public class UsingStack {
    public static void main(String[] args) {

    }
}
