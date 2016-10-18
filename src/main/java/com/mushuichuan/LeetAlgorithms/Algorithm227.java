package com.mushuichuan.LeetAlgorithms;

/**
 * Implement a basic calculator to evaluate a simple expression string.
 * <p>
 * The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.
 * <p>
 * You may assume that the given expression is always valid.
 * <p>
 * Some examples:
 * "3+2*2" = 7
 * " 3/2 " = 1
 * " 3+5 / 2 " = 5
 */
public class Algorithm227 {

    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int sumValue = 0;
        int pre = 0, cur = 0;
        char sign = '+';
        int i = 0;
        while (i < s.length()) {
            cur = 0;
            while (i < s.length() && ((s.charAt(i) >= '0' && s.charAt(i) <= '9') || s.charAt(i) == ' ')) {
                if (s.charAt(i) == ' ') {
                    i++;
                    continue;
                }
                // is number
                cur = cur * 10 + (s.charAt(i) - '0');
                i++;
            }
//			System.out.println(cur);
            if (sign == '+') {
                sumValue += pre;
                pre = cur;
            } else if (sign == '-') {
                sumValue += pre;
                pre = -cur;
            } else if (sign == '*') {
                pre = pre * cur;
            } else if (sign == '/') {
                pre = pre / cur;
            }
            if (i < s.length()) {
                sign = s.charAt(i);
                i++;
            }

        }
        return sumValue + pre;
    }
}
