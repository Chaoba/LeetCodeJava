package com.mushuichuan.LeetAlgorithms;

import java.util.HashMap;

/**
 * 128. Longest Consecutive Sequence  QuestionEditorial Solution  My Submissions
 * Total Accepted: 71449
 * Total Submissions: 214851
 * Difficulty: Hard
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 * <p>
 * For example,
 * Given [100, 4, 200, 1, 3, 2],
 * The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
 * <p>
 * Your algorithm should run in O(n) complexity.
 * Created by Liyanshun on 2016/7/26.
 */
public class Algorithm128 {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                int leftKey = nums[i] - 1;
                int leftNum = map.containsKey(leftKey) ? map.get(leftKey) : 0;
                int rightKey = nums[i] + 1;
                int rightNum = map.containsKey(rightKey) ? map.get(rightKey) : 0;
                int num = leftNum + rightNum + 1;
                max = max < num ? num : max;
                map.put(nums[i], num);
                map.put(nums[i] - leftNum, num);
                map.put(nums[i] + rightNum, num);
            }
        }

        return max;
    }
}
