package com.java.dsa.string;

public class L11StringToIntegerAtoi {

    static int selfTry(String s) {
        int i = 0, sign = 1;
        long num = 0;

        while (i < s.length() && s.charAt(i) == ' ')
            i++;

        if (i < s.length() && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }

        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';

            num = num * 10 + digit;

            if (sign * num > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;

            if (sign * num < Integer.MIN_VALUE)
                return Integer.MIN_VALUE;

            i++;
        }
        return (int) (sign * num);
    }

    public static void main(String[] args) {
//        String s = "1337c0d3";
        String s = "0-1";

        System.out.println("num: " + selfTry(s));

    }
}
