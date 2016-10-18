package com.mushuichuan.LeetAlgorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 229. Majority Element II  QuestionEditorial Solution  My Submissions
 * Total Accepted: 32750
 * Total Submissions: 123890
 * Difficulty: Medium
 * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times. The algorithm should run in linear time and in O(1) space.
 */
public class Algorithm229 {

    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList(2);
        if (nums == null || nums.length == 0) {
            return list;
        }
        HashMap<Integer, Integer> map = new HashMap();
        int maxKey = -1, secKey = -1, max = 0, secMax = 0;
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            int realCount = 0;
            Object o = map.get(n);
            if (o != null) {
                int count = (int) o;
                realCount = count + 1;
                map.put(n, realCount);
            } else {
                map.put(n, 1);
                realCount = 1;
            }
            if (realCount > max) {
                if (n == maxKey) {

                } else {
                    secMax = max;
                    secKey = maxKey;
                    maxKey = n;
                }
                max = realCount;
            } else if (realCount > secMax) {
                secKey = n;
                secMax = realCount;
            }

        }
        if (max > nums.length / 3)
            list.add(maxKey);
        if (secMax > nums.length / 3)
            list.add(secKey);
        return list;
    }
}
