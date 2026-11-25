package com.java.dsa.bitManipulation;

public class Introduction {

    static String convertToBinary(int n) {
        if (n == 0) return "0";

        StringBuilder sb = new StringBuilder();

        while (n > 0) {
            sb.append(n % 2); // last bit {sb.append(n & 1);}
            n /= 2; // divide by 2 {n >>= 1}
        }

        return sb.reverse().toString();
    }

    static int convertToDecimal(String str) {
        int ans = 0;

        for (int i = 0; i < str.length(); i++) {
            ans = (ans * 2) + (str.charAt(i) - '0');
        }       // ans << 1

        return ans;
    }

    public static void main(String[] args) {
        int number = 7;
        String string = "111";

        System.out.println(convertToBinary(number));
        System.out.println(convertToDecimal(string));
    }
}
