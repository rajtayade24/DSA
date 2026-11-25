package com.java.dsa.string;

import java.util.*;

public class L13SumOfBeautyOfAllSubstrings {

    static int beautySum(String s) {
        int n = s.length();
        int sum = 0;

        for (int i = 0; i < n; i++) {
            int[] freq = new int[26];

            for (int j = i; j < n; j++) {
                freq[s.charAt(j) - 'a']++;

                int min = Integer.MAX_VALUE;
                int max = 0;

                for (int f : freq) {
                    if (f > 0) {
                        min = Math.min(min, f);
                        max = Math.max(max, f);
                    }
                }

                sum += max - min;
            }
        }

        return sum;
    }

    static int selfTry(String s) {
        if (s.isEmpty()) return 0;

        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            HashMap<Character, Integer> map = new HashMap<>();

            for (int j = i; j < s.length(); j++) {
                char ch = s.charAt(j);
                map.put(ch, map.getOrDefault(ch, 0) + 1);

                int min = Integer.MAX_VALUE;
                int max = Integer.MIN_VALUE;

                for (int value : map.values()) {
                    min = Math.min(min, value);
                    max = Math.max(max, value);
                }

                sum += max - min;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
//        String s = "aabcb";
        String s = "aabcbaa";
        System.out.println("Ans: " + beautySum(s));
    }

}
