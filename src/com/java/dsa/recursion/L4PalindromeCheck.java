package com.java.dsa.recursion;

public class L4PalindromeCheck {

    static boolean isPalindrome(String str, int left, int right) {
        // Base Case
        if (left >= right)
            return true;

        if (str.charAt(left) != str.charAt(right))
            return false;

        return isPalindrome(str, left + 1, right - 1);
    }

    public static void main(String[] args) {
        String str = "aaabbbaa";

        if (isPalindrome(str, 0, str.length() - 1)) {
            System.out.println("String is palindrome");
        } else {
            System.out.println("String is not palindrome");
        }
    }
}
