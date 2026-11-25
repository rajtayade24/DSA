package com.java.dsa.string;

import java.util.HashMap;

public class L7CheckIfTwoStringsAreAnagrams {

    static boolean optimal(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] freq = new int[26];

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        for (char ch : t.toCharArray()) {
            freq[ch - 'a']--;
        }

        for (int val : freq) {
            if (val != 0) return false;
        }

        return true;
    }

    static boolean selfTry(String s, String t) {
        if (s.length() != t.length()) return false;

        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if (!map.containsKey(ch))
                return false;
            else {
                if (map.get(ch) > 1)
                    map.put(ch, map.getOrDefault(ch, 0) - 1);
                else
                    map.remove(ch);
            }
        }
        return true;
    }

    static boolean checkInclusion(String s, String t) {
        if (s.length() > t.length()) return false;

        int[] freq = new int[26];

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        int left = 0, right = 0, count = s.length();

        while (right < t.length()) {
            char r = t.charAt(right);

            if (freq[r - 'a'] > 0) count--;
            freq[r - 'a']--;
            right++;

            if (right - left > s.length()) {
                char l = t.charAt(left);

                if (freq[l - 'a'] >= 0) count++;
                freq[l - 'a']++;
                left++;
            }

            if (count == 0) return true;
        }

        return false;
    }


    public static void main(String[] args) {
        String s = "ababb", t = "bbaba";

        if (selfTry(s, t))
            System.out.println("The string is anagram");
        else
            System.out.println("The given string is not anagram");
    }
}
