package com.java.dsa.stackAndQueue;

import java.util.Stack;

public class L4InfixToPostfixConversion {

    static int priority(char ch) {
        return switch (ch) {
            case '^' -> 3;
            case '*', '/' -> 2;
            case '+', '-' -> 1;
            default -> -1;
        };
    }

    static String infixToPostfix(String s) {
        Stack<Character> st = new Stack<>();
        StringBuilder ans = new StringBuilder();

        for (char ch : s.toCharArray()) {

            if (Character.isLetterOrDigit(ch)) {
                ans.append(ch);
            } else if (ch == '(') {
                st.push(ch);
            } else if (ch == ')') {
                while (!st.isEmpty() && st.peek() != '(') {
                    ans.append(st.pop());
                }
                st.pop();
            } else {
                while (!st.isEmpty()
                        && st.peek() != '('
                        && priority(ch) <= priority(st.peek())) {
                    ans.append(st.pop());
                }
                st.push(ch);
            }
        }

        while (!st.isEmpty()) {
            ans.append(st.pop());
        }

        return ans.toString();
    }

    // Infix -> Prefix
    static String infixToPrefix(String s) {

        StringBuilder rev = new StringBuilder(s).reverse();

        // Swap brackets
        for (int i = 0; i < rev.length(); i++) {
            if (rev.charAt(i) == '(') {
                rev.setCharAt(i, ')');
            } else if (rev.charAt(i) == ')') {
                rev.setCharAt(i, '(');
            }
        }

        String postfix = infixToPostfix(rev.toString());

        return new StringBuilder(postfix).reverse().toString();
    }

    public static void main(String[] args) {
        String s = "a+b*(c^d-e)";

        System.out.println("Postfix: " + infixToPostfix(s));
        System.out.println("Prefix: " + infixToPrefix(s));
    }
}
