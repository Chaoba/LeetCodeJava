package com.mushuichuan.test;

import com.mushuichuan.Algorithm169;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Liyanshun on 2016/7/22.
 */
public class TestAlgorithm169 {
    @Test
    public void test1() {
        int[] i = {1, 2, 1, 3, 1, 1, 4, 5, 1, 1, 1};
        assertEquals(1, new Algorithm169().majorityElement(i));
    }

    @Test
    public void test2() {
        int[] i = {3,3,4};
        assertEquals(3, new Algorithm169().majorityElement(i));
    }
}
