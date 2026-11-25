package com.java.dsa.string;

public class L9MaximumNestingDepthOfTheParentheses {

    static int selfTry(String s) {
        int depth = 0;
        int maxDepth = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                depth++;
                maxDepth = Math.max(maxDepth, depth);
            } else if (ch == ')') {
                depth--;
            }
        }
        return maxDepth;
    }

    public static void main(String[] args) {
        String s = "(1+(2*3)+((8)/4))+1";
//        String s = "(1)+((2))+(((3)))";
//        String s = "()(())((()()))";

        System.out.println("Ans: " + selfTry(s));
    }
}
