package com.java.dsa.string;

import java.util.Arrays;

public class L4LongestCommonPrefix {

    static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";

        int minLen = strs[0].length();

        for (String str : strs) {
            minLen = Math.min(minLen, str.length());
        }

        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < minLen; i++) {
            char ch = strs[0].charAt(i);

            for (int j = 1; j < strs.length; j++) {
                if (strs[j].charAt(i) != ch) {
                    return ans.toString();
                }
            }

            ans.append(ch);
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
//        String[] strs = {"dog", "racecar", "car"};

        System.out.println("Given Strings: " + Arrays.toString(strs));
        System.out.println("Final ans: " + longestCommonPrefix(strs));
    }
}
