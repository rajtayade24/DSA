package com.java.dsa.string;

import java.util.HashMap;

public class L10RomanToInteger {

    static int optimal(String s) {
        int[] val = new int[26];

        val['I' - 'A'] = 1;
        val['V' - 'A'] = 5;
        val['X' - 'A'] = 10;
        val['L' - 'A'] = 50;
        val['C' - 'A'] = 100;
        val['D' - 'A'] = 500;
        val['M' - 'A'] = 1000;

        int ans = 0;

        for (int i = 0; i < s.length(); i++) {
            int curr = val[s.charAt(i) - 'A'];

            if (i < s.length() - 1 && curr < val[s.charAt(i + 1) - 'A']) {
                ans -= curr;
            } else {
                ans += curr;
            }
        }

        return ans;
    }

    static int romanToInt(String s) {
        int ans = 0;

        for (int i = 0; i < s.length(); i++) {

            int curr = value(s.charAt(i));

            if (i < s.length() - 1 &&
                    curr < value(s.charAt(i + 1))) {
                ans -= curr;
            } else {
                ans += curr;
            }
        }

        return ans;
    }

    static int value(char ch) {
        switch (ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }

    static int selfTry(String s) {
        if (s.isBlank()) return 0;

        HashMap<Character, Integer> map = getRomalHashMap();
        int ans = 0;

        int i = 0;
        while (i < s.length() - 1) {
            int currVal = map.get(s.charAt(i));
            int nextVal = map.get(s.charAt(i + 1));

            if (currVal >= nextVal) {
                ans += currVal;
                i++;
                if (i == s.length() - 2)
                    ans += nextVal;
            } else {
                ans += nextVal - currVal;
                i += 2;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "MCMXCIV";

        System.out.println("Ans: " + selfTry(s));
    }

    static HashMap<Character, Integer> getRomalHashMap() {

        HashMap<Character, Integer> map = new HashMap<>();

        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        return map;
    }
}
