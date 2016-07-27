package com.mushuichuan;


/**
 * 198. House Robber  QuestionEditorial Solution  My Submissions
 * Total Accepted: 81024
 * Total Submissions: 227965
 * Difficulty: Easy
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 * <p>
 * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
 * Created by Liyanshun on 2016/7/27.
 */
public class Algorithm198 {
    public int rob(int[] nums) {
        int robPre = 0, notRobPre = 0;
        for (int i = 0; i < nums.length; i++) {
            int temp = notRobPre;
            notRobPre = Integer.max(notRobPre, robPre);
            robPre = temp + nums[i];
        }
        return Integer.max(notRobPre, robPre);
    }

    public int rob2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[][] T = new int[nums.length][2];
        T[0][0] = 0;
        T[0][1] = nums[0];
        if (nums.length > 1) {
            for (int i = 1; i < nums.length; i++) {
                T[i][0] = Math.max(T[i - 1][0], T[i - 1][1]);
                T[i][1] = T[i - 1][0] + nums[i];
            }
        }
        return Math.max(T[nums.length - 1][0], T[nums.length - 1][1]);
    }

    public int rob1(int[] nums) {
        int count1 = 0;
        int count2 = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                count1 = Math.max(count1 + nums[i], count2);
            } else {
                count2 = Math.max(count2 + nums[i], count1);
            }
        }
        return Math.max(count1, count2);
    }
}
