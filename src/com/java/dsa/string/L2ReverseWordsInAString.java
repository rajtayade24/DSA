package com.java.dsa.string;

public class L2ReverseWordsInAString {

    // Overall: O(n)
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
        String s = "a good   example         ";

        System.out.println("Given String: " + s);

        String ans = selfTry(s); // "example good a"

        System.out.println("Final ans: " + ans);
    }

}
