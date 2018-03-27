package com.mushuichuan.test.testLeetAlgorithms;

import com.mushuichuan.LeetAlgorithms.Algorithm803;
import com.mushuichuan.LeetAlgorithms.Algorithm805;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertArrayEquals;

/**
 * Created by Liyanshun on 2016/7/22.
 */
public class TestAlgorithm805 {

    @Test
    public void test1() {

        Algorithm805 testAlgorithm805 = new Algorithm805();
        int[] src = {18, 10, 5, 3};

        assertEquals(false, testAlgorithm805.splitArraySameAverage(src));
    }

    @Test
    public void test2() {

        Algorithm805 testAlgorithm805 = new Algorithm805();
        int[] src = {6, 8, 18, 3, 1};

        assertEquals(false, testAlgorithm805.splitArraySameAverage(src));
    }

    @Test
    public void test3() {

        Algorithm805 testAlgorithm805 = new Algorithm805();
        int[] src = {18, 0, 16, 2};

        assertEquals(true, testAlgorithm805.splitArraySameAverage(src));
    }

    @Test
    public void test4() {

        Algorithm805 testAlgorithm805 = new Algorithm805();
        int[] src = {2, 12, 18, 16, 19, 3};

        assertEquals(false, testAlgorithm805.splitArraySameAverage(src));
    }


}
