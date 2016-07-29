package com.mushuichuan;

/**
 * 213. House Robber II  QuestionEditorial Solution  My Submissions
 * Total Accepted: 33852
 * Total Submissions: 106791
 * Difficulty: Medium
 * Note: This is an extension of House Robber.
 * <p>
 * After robbing those houses on that street, the thief has found himself a new place for his thievery so that he will not get too much attention. This time, all houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, the security system for these houses remain the same as for those in the previous street.
 * <p>
 * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the polic
 * Created by Liyanshun on 2016/7/28.
 */
public class Algorithm213 {
    public int robLine(int[] n, int beg, int end) {
        int robPre = 0;
        int notRobPre = 0;
        for (int i = beg; i < end; i++) {
            int temp = notRobPre;
            notRobPre = Integer.max(robPre, notRobPre);
            robPre = temp + n[i];
        }
        return Integer.max(notRobPre, robPre);
    }

    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        return Integer.max(robLine(nums, 0, nums.length - 1), robLine(nums, 1, nums.length));
    }
}
