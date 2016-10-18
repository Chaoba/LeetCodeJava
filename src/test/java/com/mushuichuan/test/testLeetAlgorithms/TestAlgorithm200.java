package com.mushuichuan.test.testLeetAlgorithms;

import com.mushuichuan.LeetAlgorithms.Algorithm200;
import com.mushuichuan.test.TestUtils;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Liyanshun on 2016/7/22.
 */
public class TestAlgorithm200 {
    @Test
    public void test1() {
        String[] string = {"11110", "11010", "11000", "00000"};
        char[][] s = TestUtils.createCharArray(string);

        int solution = new Algorithm200().numIslands(s);
        assertEquals(1, solution);
    }

    @Test
    public void test2() {
        String[] string = {"11000", "11000", "00100", "00011"};
        char[][] s = TestUtils.createCharArray(string);

        int solution = new Algorithm200().numIslands(s);
        assertEquals(3, solution);
    }
}
