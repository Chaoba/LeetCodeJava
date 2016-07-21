package com.mushuichuan;

/**
 * 172. Factorial Trailing Zeroes  QuestionEditorial Solution  My Submissions
 * Total Accepted: 65279
 * Total Submissions: 194272
 * Difficulty: Easy
 * Given an integer n, return the number of trailing zeroes in n!.
 * <p>
 * Note: Your solution should be in logarithmic time complexity.
 * Created by Liyanshun on 2016/7/21.
 */
public class Algorithm172 {

    public int trailingZeroes(int n) {
        if (n == 0) {
            return 0;
        }
        int count = 0;
        int divide = 5;
        int result = 0;
        // we need care about 5, 5×5, 5×5×5, 5×5×5×5
        do {
            result = n / divide;
            count += result;
            divide *= 5;
        } while (result > 1);
        return count;
    }
}
