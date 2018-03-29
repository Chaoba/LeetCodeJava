package com.mushuichuan.test.testLeetAlgorithms;

import com.mushuichuan.LeetAlgorithms.Al692;
import com.mushuichuan.LeetAlgorithms.Algorithm805;
import org.junit.Test;

import java.util.List;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by Liyanshun on 2016/7/22.
 */
public class TestAlgorithm692 {

    @Test
    public void test1() {

        Al692 testAlgorithm = new Al692();
        String[] src = {"i", "love", "leetcode", "i", "love", "coding"};

        List<String> strings = testAlgorithm.topKFrequent(src, 3);
        for(String s: strings){
            System.out.println(s);
        }
    }


}