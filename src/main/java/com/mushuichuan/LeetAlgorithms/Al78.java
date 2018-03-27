package com.mushuichuan.LeetAlgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Al78 {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, result, new ArrayList<Integer>(), 0);
        return result;
    }


    void backtrack(int[] nums, List<List<Integer>> result, List<Integer> temp, int start) {
        result.add(new ArrayList(temp));
        for (int i = start; i < nums.length; i++) {
            temp.add(nums[i]);
            backtrack(nums, result, temp, i + 1);
            temp.remove(temp.size() - 1);
        }
    }

}
