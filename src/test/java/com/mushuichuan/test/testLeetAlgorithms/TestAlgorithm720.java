package com.mushuichuan.test.testLeetAlgorithms;

import com.mushuichuan.LeetAlgorithms.Al720;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Liyanshun on 2016/7/22.
 */
public class TestAlgorithm720 {

    @Test
    public void test1() {

        Al720 testAlgorithm = new Al720();

        String[] wrords = {"a","banana","app","appl","ap","apply","apple"};
        assertEquals("apple", testAlgorithm.longestWord1(wrords));
    }




}
