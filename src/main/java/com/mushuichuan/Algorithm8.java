package com.mushuichuan;

/**
 * 8. String to Integer (atoi)  QuestionEditorial Solution  My Submissions
 * Total Accepted: 112046
 * Total Submissions: 820050
 * Difficulty: Easy
 * Implement atoi to convert a string to an integer.
 * <p>
 * Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.
 * Created by Liyanshun on 2016/7/8.
 */
public class Algorithm8 {
    public int myAtoi(String str) {
        String temp = str.trim();
        char[] c = temp.toCharArray();
        if (c.length == 0) {
            return 0;
        }
        int max = Integer.MAX_VALUE / 10;
        int min = Integer.MIN_VALUE / 10;

        int result = 0;
        int pw = 10;
        int index = 0;
        boolean minus = false;
        if (c[0] == '-') {
            index++;
            minus = true;
        } else if (c[0] == '+') {
            index++;
        }
        while (index < c.length && c[index] >= '0' && c[index] <= '9') {
            if (result >= max) {
                return Integer.MAX_VALUE;
            } else if (result <= min) {
                return Integer.MIN_VALUE;
            }
            int i = result * pw;
            int i1 = c[index++] - 48;
            if (minus) {
                if (i > 0)
                    i = -i;
                i1 = -i1;
            }
            result = i + i1;
        }
        return result;
    }
}
