package com.mushuichuan.test.testLeetAlgorithms;

import com.mushuichuan.LeetAlgorithms.Algorithm374;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Liyanshun on 2016/7/22.
 */
public class TestAlgorithm374 {

    @Test
    public void test1() {

        Algorithm374 testAlgorithm374 = new Algorithm374();
        testAlgorithm374.setGuess(6);
        assertEquals(6, testAlgorithm374.guessNumber(10));
        assertEquals(6, testAlgorithm374.guessNumber(10000));

    }

    @Test
    public void test2() {

        Algorithm374 testAlgorithm374 = new Algorithm374();
        testAlgorithm374.setGuess(2345354);
        assertEquals(2345354, testAlgorithm374.guessNumber(45353334));
        assertEquals(2345354, testAlgorithm374.guessNumber(345532222));

    }

    @Test
    public void test3() {

        Algorithm374 testAlgorithm374 = new Algorithm374();
        testAlgorithm374.setGuess(1);
        assertEquals(1, testAlgorithm374.guessNumber(1));

    } @Test
    public void test4() {

        Algorithm374 testAlgorithm374 = new Algorithm374();
        testAlgorithm374.setGuess(1);
        assertEquals(1, testAlgorithm374.guessNumber(2));

    }

    @Test
    public void test5() {

        Algorithm374 testAlgorithm374 = new Algorithm374();
        testAlgorithm374.setGuess(1);
        assertEquals(1, testAlgorithm374.guessNumber(3));

    }

    @Test
    public void test6() {

        Algorithm374 testAlgorithm374 = new Algorithm374();
        testAlgorithm374.setGuess(2);
        assertEquals(2, testAlgorithm374.guessNumber(4));

    }

    @Test
    public void test7() {

        Algorithm374 testAlgorithm374 = new Algorithm374();
        testAlgorithm374.setGuess(2147483647);
        assertEquals(2147483647, testAlgorithm374.guessNumber(2147483647));

    }

    @Test
    public void test8() {

        Algorithm374 testAlgorithm374 = new Algorithm374();
        testAlgorithm374.setGuess(10);
        assertEquals(10, testAlgorithm374.guessNumber(10));

    }
}
