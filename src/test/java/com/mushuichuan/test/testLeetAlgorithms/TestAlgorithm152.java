package com.mushuichuan.test.testLeetAlgorithms;

import com.mushuichuan.LeetAlgorithms.Algorithm152;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Created by Liyanshun on 2016/7/18.
 */
public class TestAlgorithm152 {
    @Test
    public void test1() {
        int[] source = {-4,-3,-2};
        int solution = new Algorithm152().maxProduct(source);
        assertEquals(12, solution);

    }
 @Test
    public void test2() {
        int[] source = {1,0,-1,2,3,-5,-2};
        int solution = new Algorithm152().maxProduct(source);
        assertEquals(60, solution);

    }


}
