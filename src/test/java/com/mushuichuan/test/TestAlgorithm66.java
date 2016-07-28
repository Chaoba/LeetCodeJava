package com.mushuichuan.test;

import com.mushuichuan.Algorithm66;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by Liyanshun on 2016/7/28.
 */
public class TestAlgorithm66 {

    @Test
    public void test1() {
        int[] s = {1, 2, 3, 4};
        int[] r = {1, 2, 3, 5};

        assertArrayEquals(r, new Algorithm66().plusOne(s));
    }

    @Test
    public void test2() {
        int[] s = {1};
        int[] r = {2};
        assertArrayEquals(r, new Algorithm66().plusOne(s));
    }

    @Test
    public void test3() {
        int[] s = {9};
        int[] r = {1, 0};
        assertArrayEquals(r, new Algorithm66().plusOne(s));
    }

    @Test
    public void test4() {
        int[] s = {9, 9};
        int[] r = {1, 0, 0};
        assertArrayEquals(r, new Algorithm66().plusOne(s));
    }

}
