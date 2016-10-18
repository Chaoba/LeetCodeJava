package com.mushuichuan.LeetAlgorithms;

/**
 * 190. Reverse Bits  QuestionEditorial Solution  My Submissions
 * Total Accepted: 70176
 * Total Submissions: 238645
 * Difficulty: Easy
 * Reverse bits of a given 32 bits unsigned integer.
 * <p>
 * For example, given input 43261596 (represented in binary as 00000010100101000001111010011100), return 964176192 (represented in binary as 00111001011110000010100101000000).
 * Created by Liyanshun on 2016/7/21.
 */
public class Algorithm190 {
    public int reverseBits(int n) {
        int r = 0;
        for (int i = 0; i < 32; i++) {
            int temp = n & 1;
            r = r << 1;
            r = r | temp;

            n = n >> 1;
        }
        return r;
    }
}
