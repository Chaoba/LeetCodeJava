package com.mushuichuan;

/**
 * Created by Liyanshun on 2016/7/18.
 */
public class Algorithm1 {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            int sub = target - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (sub == nums[j]) {
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }
        }
        return result;
    }
}
