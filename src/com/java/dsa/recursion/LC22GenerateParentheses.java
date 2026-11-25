package com.java.dsa.recursion;

import java.util.ArrayList;
import java.util.List;

public class LC22GenerateParentheses {

    static List<String> rec(StringBuilder sb, int open, int close, List<String> ans, int n) {
        if (open == n && close == n) {
            ans.add(sb.toString());
            return ans;
        }

        if (open < n) {
            sb.append('(');
            rec(sb, open + 1, close, ans, n);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (close < open) {
            sb.append(')');
            rec(sb, open, close + 1, ans, n);
            sb.deleteCharAt(sb.length() - 1);
        }

        return ans;
    }

    static List<String> selfTry(int n) {
        return rec(new StringBuilder(), 0, 0, new ArrayList<>(), n);
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println(selfTry(n));
    }
}
