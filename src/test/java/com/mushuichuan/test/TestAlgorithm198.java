package com.mushuichuan.test;

import com.mushuichuan.Algorithm198;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Liyanshun on 2016/7/18.
 */
public class TestAlgorithm198 {
    @Test
    public void test1() {
        int[] source = {2, 7, 11, 15};

        int solution = new Algorithm198().rob(source);
        assertEquals(22, solution);

    }

    @Test
    public void test2() {
        int[] source = {2};

        int solution = new Algorithm198().rob(source);
        assertEquals(2, solution);

    }
    @Test
    public void test3() {
        int[] source = {2, 7};

        int solution = new Algorithm198().rob(source);
        assertEquals(7, solution);

    }

    @Test
    public void test4() {
        int[] source = {};

        int solution = new Algorithm198().rob(source);
        assertEquals(0, solution);

    }
}
