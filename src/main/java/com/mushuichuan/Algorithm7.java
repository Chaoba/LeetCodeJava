package com.mushuichuan;

/**
 * 7. Reverse Integer  QuestionEditorial Solution  My Submissions
 * Total Accepted: 152034
 * Total Submissions: 639735
 * Difficulty: Easy
 * Reverse digits of an integer.
 * <p>
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 * Created by Liyanshun on 2016/7/8.
 */
public class Algorithm7 {
    public int reverse(int x) {
        int max = Integer.MAX_VALUE / 10;
        int min = Integer.MIN_VALUE / 10;
        int result = 0;
        while (x != 0) {
            result = result * 10 + x % 10;
            x /= 10;
            if (x != 0 && (result > max || result < min)) {
                return 0;
            }
        }
        if (x < 0) {
            result = -result;
        }
        return result;
    }
}
