package com.java.dsa.string;

public class L12LongestPalindromicSubstring {

    static int expand(String s, int left, int right) {
        while (left >= 0 && right < s.length()
                && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    static String betterSol(String s) {
        if (s == null || s.isEmpty()) return "";

        int start = 0, end = 0;

        for (int i = 0; i < s.length(); i++) {
            int len1 = expand(s, i, i);       // odd
            int len2 = expand(s, i, i + 1);   // even

            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--))
                return false;
        }
        return true;
    }

    static String selfTry(String s) {
        if (s.isEmpty())
            return "";

        String maxStr = "";

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String subStr = s.substring(i, j);
                if (isPalindrome(subStr) && subStr.length() > maxStr.length()) {
                    maxStr = subStr;
                }
            }
        }
        return maxStr;
    }


    public static void main(String[] args) {
        String s = "babad";

        System.out.println(selfTry(s));
    }
}
