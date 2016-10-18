package com.mushuichuan.LeetAlgorithms;

/**
 * 115. Distinct Subsequences  QuestionEditorial Solution  My Submissions
 * Total Accepted: 54369
 * Total Submissions: 184996
 * Difficulty: Hard
 * Given a string S and a string T, count the number of distinct subsequences of T in S.
 * <p>
 * A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
 * <p>
 * Here is an example:
 * S = "rabbbit", T = "rabbit"
 * <p>
 * Return 3.
 * Created by Liyanshun on 2016/7/11.
 */
public class Algorithm115 {

    public int numDistinct(String s, String t) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (t == null || t.length() == 0) {
            return 1;
        }
        char[] sc = s.toCharArray();
        char[] st = t.toCharArray();
        int[][] T = new int[st.length + 1][sc.length + 1];
        for (int i = 0; i <= sc.length; i++) {
            T[0][i] = 1;
        }

        for (int i = 0; i < st.length; i++) {
            for (int j = 0; j < sc.length; j++) {
                if (i > j) {
                    T[i + 1][j + 1] = 0;
                } else {
                    if (st[i] == sc[j]) {
                        T[i + 1][j + 1] = T[i][j] + T[i + 1][j];
                    } else {
                        T[i + 1][j + 1] = T[i + 1][j];
                    }
                }
            }
        }

        return T[st.length][sc.length];
    }
}
