package com.mushuichuan.LeetAlgorithms;

/**
 * 5. Longest Palindromic Substring  QuestionEditorial Solution  My Submissions
 * Total Accepted: 119347
 * Total Submissions: 506473
 * Difficulty: Medium
 * Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
 * Created by Liyanshun on 2016/7/20.
 */
public class Algorithm5 {
    char[] ch;

    public String longestPalindrome(String s) {
        int len = s.length();
        if (len == 1) {
            return s;
        }
        ch = s.toCharArray();

        int begin = 0, end = 0, maxlen = 0;

        for (int i = 0; i < len; i++) {
            //assume maxlen=3, we only need to check i-3 and i-4, since if i-5 to i is palindrome, maxlen will be 4
            if (isPalindromic(i - maxlen - 1, i)) {

                begin = i - maxlen - 1;
                end = i + 1;
                maxlen += 2;
            } else if (isPalindromic(i - maxlen, i)) {

                begin = i - maxlen;
                end = i + 1;
                maxlen += 1;
            }
        }
        return s.substring(begin, end);
    }

    boolean isPalindromic(int begin, int end) {
        if (begin < 0) {
            return false;
        }
        while (begin < end) {
            if (ch[begin++] != ch[end--]) {
                return false;
            }
        }
        return true;
    }
}
