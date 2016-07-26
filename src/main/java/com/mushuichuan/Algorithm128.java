package com.mushuichuan;

import java.util.HashMap;

/**
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
