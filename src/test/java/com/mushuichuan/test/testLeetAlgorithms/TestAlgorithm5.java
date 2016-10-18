package com.mushuichuan.test.testLeetAlgorithms;

import com.mushuichuan.LeetAlgorithms.Algorithm5;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * Created by Liyanshun on 2016/7/18.
 */
public class TestAlgorithm5 {
    @Test
    public void test1() {
        String s1 = "12345654546";
        String result = new Algorithm5().longestPalindrome(s1);
        assertEquals("45654", result);
    }


}
