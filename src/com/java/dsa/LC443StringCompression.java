package com.java.dsa;

public class LC443StringCompression {

    static int compress(char[] chars) {

        int index = 0;
        int i = 0;

        while (i < chars.length) {

            char ch = chars[i];
            int count = 0;

            while (i < chars.length && chars[i] == ch) {
                i++;
                count++;
            }

            chars[index++] = ch;

            if (count > 1) {
                String digits = String.valueOf(count);

                for (char digit : digits.toCharArray()) {
                    chars[index++] = digit;
                }
            }
        }
        return index;
    }


}
