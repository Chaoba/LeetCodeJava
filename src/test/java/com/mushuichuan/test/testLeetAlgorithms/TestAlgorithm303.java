package com.mushuichuan.test.testLeetAlgorithms;

import com.mushuichuan.LeetAlgorithms.Algorithm303;
import com.mushuichuan.LeetAlgorithms.Algorithm342;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class TestAlgorithm303 {
    @Test
    public void test1() {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        Algorithm303 Algorithm303 = new Algorithm303(nums);
        assertEquals(1, Algorithm303.sumRange(0, 2));
        assertEquals(-1, Algorithm303.sumRange(2, 5));
        assertEquals(-3, Algorithm303.sumRange(0, 5));
    }

    @Test
    public void test2() {
        int[] nums = {1};
        Algorithm303 Algorithm303 = new Algorithm303(nums);
        assertEquals(1, Algorithm303.sumRange(0, 0));
    }

    @Test
    public void test3() {
        int[] nums = {1, 2};
        Algorithm303 Algorithm303 = new Algorithm303(nums);
        assertEquals(1, Algorithm303.sumRange(0, 0));
        assertEquals(3, Algorithm303.sumRange(0, 1));
    }

}
