package com.mushuichuan.test;

import com.mushuichuan.Algorithm274;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Liyanshun on 2016/7/18.
 */
public class TestAlgorithm274 {

    @Test
    public void test1() {
        String s = "[3, 0, 6, 1, 5]";
        int index = new Algorithm274().hIndex(TestUtils.createIntArray(s));
        assertEquals(3, index);
    }

    @Test
    public void test2() {
        String s = "[1, 2, 3, 4, 5,6,7]";
        int index = new Algorithm274().hIndex(TestUtils.createIntArray(s));
        assertEquals(4, index);
    }

    @Test
    public void test3() {
        String s = "[100]";
        int index = new Algorithm274().hIndex(TestUtils.createIntArray(s));
        assertEquals(1, index);
    }


}
