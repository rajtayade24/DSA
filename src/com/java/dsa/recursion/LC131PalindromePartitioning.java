//package com.java.dsa.recursion;
//
//import java.util.List;
//
//public class LC131PalindromePartitioning {
//
//    static boolean isPalindrome(String str, int left, int right) {
//        // Base Case
//        if (left >= right)
//            return true;
//
//        if (str.charAt(left) != str.charAt(right))
//            return false;
//
//        return isPalindrome(str, left + 1, right - 1);
//    }
//
//    static List<List<String>> partition(String s) {
//
//        int start = 0, end = 1, size = s.length();
//
//        for (int end = 1; end <= s.length(); end++) {
//            String substring = s.substring(start, end);
//            recurtion(substring)
//        }
//    }
//
//    public static void main(String[] args) {
//        String s = "aab";
//
//        List<List<String>> ans = partition(s);
//
//        for (List<String> list : ans) {
//            System.out.println(list);
//        }
//    }
//}
