package com.mushuichuan;


/**
 * 260. Single Number III  QuestionEditorial Solution  My Submissions
 * Total Accepted: 40866
 * Total Submissions: 89380
 * Difficulty: Medium
 * Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.
 * <p>
 * For example:
 * <p>
 * Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].
 * <p>
 * Note:
 * The order of the result is not important. So in the above example, [5, 3] is also correct.
 * Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
 * Created by Liyanshun on 2016/7/11.
 */
public class Algorithm260 {

    public int[] singleNumber(int[] nums) {
        int diff = 0;
        for (int i : nums) {
            diff ^= i;
        }
        //find the most right bit
        diff &= -diff;
        int[] result = new int[2];
        // the bits of two number is absolutely 1 and 0
        for (int i : nums) {
            if ((i & diff) == 0) {
                result[0] ^= i;
            } else {
                result[1] ^= i;
            }
        }
        return result;
    }
}
