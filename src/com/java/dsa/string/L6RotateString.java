package com.java.dsa.string;

public class L6RotateString {

    static boolean selfTry(String s, String goal) {
        if (s.length() != goal.length()) return false;
        return (s + s).contains(goal);
    }

    static boolean kmpSolution(String s, String goal) {
        if (s.length() != goal.length()) return false;

        String text = s + s;
        return kmpSearch(text, goal);
    }

    static boolean kmpSearch(String text, String pattern) {
        if (pattern.isEmpty()) return true;

        int[] lps = buildLPS(pattern);

        int left = 0, right = 0;

        while (left < text.length()) {
            if (text.charAt(left) == pattern.charAt(right)) {
                left++;
                right++;
                if (right == pattern.length()) return true;
            } else {
                if (right != 0)
                    right = lps[right - 1];
                else
                    left++;
            }
        }

        return false;
    }

    static int[] buildLPS(String p) {
        int[] lps = new int[p.length()];
        int len = 0, i = 1;

        while (i < p.length()) {
            if (p.charAt(i) == p.charAt(len)) {
                lps[i++] = ++len;
            } else {
                if (len != 0) len = lps[len - 1];
                else lps[i++] = 0;
            }
        }
        return lps;
    }

    public static void main(String[] args) {
        String s = "abcde", goal = "cdeab";

        if (kmpSolution(s, goal))
            System.out.println("The string is rotated");
        else
            System.out.println("The given string is not rotated");
    }
}
