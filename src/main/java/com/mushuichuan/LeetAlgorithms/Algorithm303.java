package com.mushuichuan.LeetAlgorithms;

/**
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 * <p>
 * Example:
 * Given nums = [-2, 0, 3, -5, 2, -1]
 * <p>
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 * Note:
 * You may assume that the array does not change.
 * There are many calls to sumRange function.
 */
public class Algorithm303 {
    int[] T;

    public Algorithm303(int[] nums) {
        for (int j = 1; j < nums.length; j++) {
            nums[j] += nums[j - 1];
        }

        T = nums;
    }

    public int sumRange(int i, int j) {
        if (i == 0) {
            return T[j];
        }
        return T[j] - T[i - 1];
    }
}
