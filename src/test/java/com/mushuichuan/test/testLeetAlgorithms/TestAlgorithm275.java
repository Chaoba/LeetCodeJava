package com.mushuichuan.test.testLeetAlgorithms;

import com.mushuichuan.LeetAlgorithms.Algorithm275;
import com.mushuichuan.test.TestUtils;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Liyanshun on 2016/7/18.
 */
public class TestAlgorithm275 {

    @Test
    public void test1() {
        String s = "[3, 0, 6, 1, 5]";
        int index = new Algorithm275().hIndex(TestUtils.createIntArray(s));
        assertEquals(3, index);
    }

    @Test
    public void test2() {
        String s = "[1, 2, 3, 4, 5,6,7]";
        int index = new Algorithm275().hIndex(TestUtils.createIntArray(s));
        assertEquals(4, index);
    }

    @Test
    public void test3() {
        String s = "[100]";
        int index = new Algorithm275().hIndex(TestUtils.createIntArray(s));
        assertEquals(1, index);
    }


}
