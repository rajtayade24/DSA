package com.java.dsa.string;

public class L14ReverseEveryWordInAString {
    static String moreOptimal(String s) {
        StringBuilder ans = new StringBuilder();
        int i = s.length() - 1;

        while (i >= 0) {

            while (i >= 0 && s.charAt(i) == ' ')
                i--;

            if (i < 0)
                break;

            int j = i;

            while (i >= 0 && s.charAt(i) != ' ')
                i--;

            ans.append(s.substring(i + 1, j + 1));

            while (i >= 0 && s.charAt(i) == ' ')
                i--;

            if (i >= 0)
                ans.append(" ");
        }

        return ans.toString();
    }

    static String selfTry(String s) {
        String[] words = s.trim().split("\\s+"); // \s Means any whitespace character
        // + Means one or more occurrences.
        // \ is an escape character.

        StringBuilder ans = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {
            ans.append(words[i]);

            if (i != 0) {
                ans.append(" ");
            }
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        String s = "  hello world  ";
        System.out.println("Ans: " + moreOptimal(s));

    }
}
