package com.java.dsa.stackAndQueue;

import java.util.Stack;

public class L2ValidParentheses {

    static boolean selfTry(String s) {

        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (!stack.isEmpty()
                    && ch == closeBracket(stack.peek())) {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }

    static char closeBracket(char ch) {
        return switch (ch) {
            case '(' -> ')';
            case '{' -> '}';
            case '[' -> ']';
            default -> throw new IllegalArgumentException("Invalid bracket: " + ch);
        };
    }

    public static void main(String[] args) {
        String s = "([])";
//        String s = "([)]";

        if (selfTry(s))
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}
