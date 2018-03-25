package com.mushuichuan.test.testLeetAlgorithms;

import com.mushuichuan.LeetAlgorithms.Algorithm374;
import com.mushuichuan.LeetAlgorithms.Algorithm803;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Created by Liyanshun on 2016/7/22.
 */
public class TestAlgorithm803 {

    @Test
    public void test1() {

        Algorithm803 testAlgorithm803 = new Algorithm803();
      int[][] grid ={{1,0,0,0},{1,1,1,0}};
      int[][] hints ={{1,0}};
        int[] result = {2};
        assertArrayEquals(result, testAlgorithm803.hitBricks(grid,hints));
    }

  @Test
    public void test2() {
        Algorithm803 testAlgorithm803 = new Algorithm803();
       int[][] grid ={{1,1,1},{0,1,0},{0,0,0}};
       int[][] hints ={{0,2},{2,0},{0,1},{1,2}};
        int[] result = {0,0,1,0};
        assertArrayEquals(result, testAlgorithm803.hitBricks(grid,hints));
    }

@Test
    public void test3() {
        Algorithm803 testAlgorithm803 = new Algorithm803();
       int[][] grid ={{0,1,1,1,1},{1,1,1,1,0},{1,1,1,1,0},{0,0,1,1,0},{0,0,1,0,0},{0,0,1,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0}};
       int[][] hints ={{6,0},{1,0},{4,3},{1,2},{7,1},{6,3},{5,2},{5,1},{2,4},{4,4},{7,3}};

    int[] result = {0,0,0,0,0,0,0,0,0,0,0};
        assertArrayEquals(result, testAlgorithm803.hitBricks(grid,hints));
    }



}
