package com.java.dsa.stackAndQueue;

import java.util.Stack;

class MinStack {

    private final Stack<Long> stack;
    private long min;

    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int value) {
        if (stack.isEmpty()) {
            stack.push((long) value);
            min = value;
        } else if (value >= min) {
            stack.push((long) value);
        } else {
            // Store encoded value
            stack.push(2L * value - min);
            min = value;
        }
    }

    public void pop() {
        if (stack.isEmpty()) return;

        long top = stack.pop();

        if (top < min) {
            // Recover previous minimum
            min = 2 * min - top;
        }
    }

    public int top() {
        long top = stack.peek();

        if (top >= min) {
            return (int) top;
        }

        // Encoded value, actual top is current minimum
        return (int) min;
    }

    public int getMin() {
        return (int) min;
    }
}

class Pair {
    int val;
    int min;

    Pair(int val, int min) {
        this.val = val;
        this.min = min;
    }
}

class UsingPair {
    Stack<Pair> stack;

    public UsingPair() {
        stack = new Stack<>();
    }

    public void push(int value) {
        if (stack.isEmpty()) {
            stack.push(new Pair(value, value));
        } else {
            int min = Math.min(value, stack.peek().min);
            stack.push(new Pair(value, min));
        }
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek().val;
    }

    public int getMin() {
        return stack.peek().min;
    }

}

class L3MinStack {

    public static void main(String[] args) {
        UsingPair st = new UsingPair();
//        MinStack st = new MinStack();

        st.push(5);
        st.push(3);
        st.push(7);
        st.push(2);

        System.out.println(st.getMin()); // 2

        st.pop();
        System.out.println(st.getMin()); // 3

        st.pop();
        System.out.println(st.getMin()); // 3

        System.out.println(st.top());    // 3
    }
}
