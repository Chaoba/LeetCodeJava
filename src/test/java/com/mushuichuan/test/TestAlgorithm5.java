package com.mushuichuan.test;

import com.mushuichuan.Algorithm5;
import com.mushuichuan.Algorithm6;
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
