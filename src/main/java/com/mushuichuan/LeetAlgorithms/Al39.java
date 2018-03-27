package com.mushuichuan.LeetAlgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Al39 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        find(candidates, result, new ArrayList<Integer>(), 0, target);

        return result;
    }

    void find(int[] candidates, List<List<Integer>> result, List<Integer> list, int begin, int target) {
        if (target == 0) {
            result.add(new ArrayList(list));
            return;
        } else if (target < 0) {
            return;
        }
        for (int i = begin; i < candidates.length; i++) {
            list.add(candidates[i]);
            find(candidates, result, list, i, target - candidates[i]);
            list.remove(list.size() - 1);

        }

    }

}
