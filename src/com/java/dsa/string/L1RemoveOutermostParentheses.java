package com.java.dsa.string;

public class L1RemoveOutermostParentheses {

    static String optimal(String s) {
        StringBuilder ans = new StringBuilder();
        int depth = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                if (depth > 0) {
                    ans.append(ch);
                }
                depth++;
            } else {
                depth--;
                if (depth > 0) {
                    ans.append(ch);
                }
            }
        }

        return ans.toString();
    }

    /// Output limit exceeded (Try better)
    static String selfTry(String s) {
        if (s.isEmpty()) return "";

        StringBuilder ans = new StringBuilder();

        int count = 0;
        StringBuilder temp = new StringBuilder();

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                temp.append("(");
                count++;
            } else {
                temp.append(")");
                count--;
            }

            if (count == 0) {
                ans.append(temp, 1, temp.length() - 1);
                temp = new StringBuilder();
            }
        }

        return ans.toString();
    }

    public static void main(String[] args) {
//        String s = "(()())(())";
        String s = "(()())(())(()(()))";

        System.out.println("Final ans: " + selfTry(s));
        System.out.println("Final ans: " + optimal(s));
    }
}