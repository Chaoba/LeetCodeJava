package com.mushuichuan.test;

import com.mushuichuan.Algorithm342;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * Created by Liyanshun on 2016/7/18.
 */
public class TestAlgorithm342 {
    @Test
    public void test1() {
        boolean result = new Algorithm342().isPowerOfFour(16);
        assertEquals(true, result);
    }

    @Test
    public void test2() {
        boolean result = new Algorithm342().isPowerOfFour(8);
        assertEquals(false, result);
    }

    @Test
    public void test3() {
        boolean result = new Algorithm342().isPowerOfFour(64);
        assertEquals(true, result);
    }

    @Test
    public void test4() {
        boolean result = new Algorithm342().isPowerOfFour(2048);
        assertEquals(false, result);
    }


}
