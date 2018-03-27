package com.mushuichuan.test.testLeetAlgorithms;

import com.mushuichuan.LeetAlgorithms.Al78;
import org.junit.Test;

import java.util.List;


/**
 * Created by Liyanshun on 2016/7/18.
 */
public class TestAlgorithm78 {
    @Test
    public void test1() {
        int[] src = {1,2,3};
        List<List<Integer>> result = new Al78().subsets(src);
        for(List<Integer> list: result){
            for(Integer i: list){
                System.out.print(i+"  ");
            }
            System.out.println();
        }

    }

}
