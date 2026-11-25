package com.java.dsa.string;

public class L3LargestOddNumberInAString {

    static String selfTry(String s) {
        if (s.isEmpty()) return "";

        for (int i = s.length() - 1; i >= 0; i--) {
            if ((s.charAt(i) - '0') % 2 == 1) {
                return s.substring(0, i + 1);
            }
        }

        return "";
    }

    public static void main(String[] args) {
        String s = "3542780";

        System.out.println("Given String: " + s);
        System.out.println("Final ans: " + selfTry(s));
    }
}
