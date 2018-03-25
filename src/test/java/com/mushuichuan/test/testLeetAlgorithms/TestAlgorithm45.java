package com.mushuichuan.test.testLeetAlgorithms;

import com.mushuichuan.LeetAlgorithms.Algorithm45;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;


/**
 * Created by Liyanshun on 2016/7/18.
 */
public class TestAlgorithm45 {
    @Test
    public void test1() {
        int[] source = {1,2};
        int solution = new Algorithm45().jump(source);
        assertEquals(1, solution);

    }
 @Test
    public void test2() {
        int[] source = {2,3,1,1,4};
        int solution = new Algorithm45().jump(source);
        assertEquals(2, solution);

    } @Test
    public void test3() {
        int[] source = {0};
        int solution = new Algorithm45().jump(source);
        assertEquals(0, solution);

    }

}
