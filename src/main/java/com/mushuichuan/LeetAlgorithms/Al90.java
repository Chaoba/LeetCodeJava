package com.mushuichuan.LeetAlgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Al90 {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result =new ArrayList<>();
        backtrace(nums, result, new ArrayList(), 0);
        for(List<Integer>list :result){
            for(Integer i: list){
                System.out.print(i+ "  ");
            }
            System.out.println();
        }
        return result;
    }

    void backtrace(int[] nums, List<List<Integer>> result, List<Integer> temp, int start){
        result.add(new ArrayList(temp));
        for(int i = start; i<nums.length;i++){
            if(i>start && nums[i]==nums[i-1]) continue;
            temp.add(nums[i]);
            backtrace(nums,result, temp, i+1);
            temp.remove(temp.size()-1);
        }
    }
}
