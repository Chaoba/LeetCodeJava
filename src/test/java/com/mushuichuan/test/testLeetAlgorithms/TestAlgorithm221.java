package com.mushuichuan.test.testLeetAlgorithms;

import com.mushuichuan.LeetAlgorithms.Al221;
import com.mushuichuan.LeetAlgorithms.Al692;
import org.junit.Test;

import java.util.List;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by Liyanshun on 2016/7/22.
 */
public class TestAlgorithm221 {

    @Test
    public void test1() {

        Al221 testAlgorithm = new Al221();
        char[][] src = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};

        int result = testAlgorithm.maximalSquare(src);
        assertEquals(4, result);
    }
    @Test
    public void test2() {

        Al221 testAlgorithm = new Al221();
        char[][] src = {{'0','0','0','1'},{'1','1','0','1'},{'1','1','1','1'},{'0','1','1','1'},{'0','1','1','1'}};

        int result = testAlgorithm.maximalSquare(src);
        assertEquals(9, result);
    }


}