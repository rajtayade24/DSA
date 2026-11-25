package com.java.dsa.string;

import java.util.HashMap;

public class L5IsomorphicStrings {

    static boolean optimal(String s, String t) {
        int[] m1 = new int[256];
        int[] m2 = new int[256];

        for (int i = 0; i < s.length(); i++) {

            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if (m1[c1] != m2[c2])
                return false;

            m1[c1] = i + 1;
            m2[c2] = i + 1;
        }

        return true;
    }

    ///  TC = C(n) SC = O(2n)
    static boolean usingHashMap(String s, String t) {

        if (s.length() != t.length()) return false;

        HashMap<Character, Character> sToT = new HashMap<>();
        HashMap<Character, Character> tToS = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);

            if (sToT.containsKey(ch1)) {
                if (sToT.get(ch1) != ch2)
                    return false;
            } else {
                sToT.put(ch1, ch2);
            }

            if (tToS.containsKey(ch2)) {
                if (tToS.get(ch2) != ch1)
                    return false;
            } else {
                tToS.put(ch2, ch1);
            }
        }

        return true;
    }

    ///  Failed for  s = "ab". t = "cc"
//    static boolean selfTry(String s, String t) {
//        if (s.isEmpty() || t.isEmpty()) return false;
//
//        HashMap<Character, Character> map = new HashMap<>();
//
//        for (int i = 0; i < s.length(); i++) {
//            if (map.containsKey(s.charAt(i))) {
//                if (map.get(s.charAt(i)) != t.charAt(i))
//                    return false;
//            } else
//                map.put(s.charAt(i), t.charAt(i));
//        }
//        return true;
//    }
    public static void main(String[] args) {
        String s = "egg", t = "add";

        if (optimal(s, t))
            System.out.println("The string is isomeric");
        else
            System.out.println("The given string is not isomeric");
    }
}
