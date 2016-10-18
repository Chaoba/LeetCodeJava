package com.mushuichuan.test.testLeetAlgorithms;

import com.mushuichuan.LeetAlgorithms.Algorithm213;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Liyanshun on 2016/7/28.
 */
public class TestAlgorithm213 {
    @Test
    public void test1() {
        int[] house = {1, 2, 3, 4};
        assertEquals(6, new Algorithm213().rob(house));
    }

    @Test
    public void test2() {
        int[] house = {1, 2, 3};
        assertEquals(3, new Algorithm213().rob(house));
    }

    @Test
    public void test3() {
        int[] house = {1, 2, 3, 4, 5};
        assertEquals(8, new Algorithm213().rob(house));
    }

    @Test
    public void test4() {
        int[] house = {6, 2, 3, 4, 5};
        assertEquals(10, new Algorithm213().rob(house));
    }

    @Test
    public void test5() {
        int[] house = {1};
        assertEquals(1, new Algorithm213().rob(house));
    }

    @Test
    public void test6() {
        int[] house = {1, 2};
        assertEquals(2, new Algorithm213().rob(house));
    }

    @Test
    public void test7() {
        int[] house = {2, 1};
        assertEquals(2, new Algorithm213().rob(house));
    }

    @Test
    public void test8() {
        int[] house = {2,2,4,3,2,5};
        assertEquals(10, new Algorithm213().rob(house));
    }

}
