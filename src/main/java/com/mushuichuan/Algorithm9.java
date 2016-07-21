package com.mushuichuan;

/**
 * 9. Palindrome Number  QuestionEditorial Solution  My Submissions
 * Total Accepted: 135362
 * Total Submissions: 416459
 * Difficulty: Easy
 * Determine whether an integer is a palindrome. Do this without extra space.
 * Created by Liyanshun on 2016/7/21.
 */
public class Algorithm9 {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        } else if (x < 10) {
            return true;
        } else if (x % 10 == 0) {
            return false;
        }
        int temp = 0;
        while (x > temp) {
            temp = temp * 10 + x % 10;
            x = x / 10;

        }
        return (temp == x || temp / 10 == x);
    }
}
