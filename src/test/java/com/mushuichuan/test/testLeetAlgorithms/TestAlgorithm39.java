package com.mushuichuan.test.testLeetAlgorithms;

import com.mushuichuan.LeetAlgorithms.Al39;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;


/**
 * Created by Liyanshun on 2016/7/18.
 */
public class TestAlgorithm39 {
    @Test
    public void test1() {
        int[] src = {2, 3, 6, 7};
        List<List<Integer>> result = new Al39().combinationSum(src, 7);
        for (List<Integer> list : result) {
            for(Integer i:list){
                System.out.print(i+"   ");
            }
            System.out.println();;
        }

    }

}
