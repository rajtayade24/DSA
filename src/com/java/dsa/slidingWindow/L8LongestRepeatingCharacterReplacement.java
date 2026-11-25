package com.java.dsa.slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class L8LongestRepeatingCharacterReplacement {

    static int selfTry(String s, int k) {

        Map<Character, Integer> map = new HashMap<>();
        int l = 0, maxFreq = 0, maxLen = 0;

        for (int r = 0; r < s.length(); r++) {
            char ch = s.charAt(r);

            map.put(ch, map.getOrDefault(ch, 0) + 1);

            maxFreq = Math.max(maxFreq, map.get(ch));

            if ((r - l + 1) - maxFreq > k) {
                char leftChar = s.charAt(l);

                map.put(leftChar, map.get(leftChar) - 1);

                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }

                l++;
            }

            maxLen = Math.max(maxLen, r - l + 1);
        }

        return maxLen;
    }

    static int selfTryBruteForce(String s, int k) {
        int n = s.length();

        int maxLen = 0;
        for (int i = 0; i < n; i++) {

            char ch = s.charAt(i);
            int sum = 0;

            for (int j = i + 1; j < n; j++) {
                if (ch != s.charAt(j)) {
                    sum++;
                }
                if (sum > k) {
                    break;
                }

                maxLen = Math.max(maxLen, j - i + 1);
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 2;

        System.out.println(selfTry(s, k));
    }
}
