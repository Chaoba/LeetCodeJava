package com.mushuichuan.test;

import com.mushuichuan.HeapSort;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by Liyanshun on 2016/7/25.
 */
public class TestHeapSort {
    @Test
    public void test1() {
        int[] s = {1, 3, 2, 5, 4, 8, 6, 7};
        int[] result = {1, 2, 3, 4, 5, 6, 7, 8};
        new HeapSort().heapSort(s);
        assertArrayEquals(result, s);
    }

    @Test
    public void test2() {
        int[] s = {1};
        int[] result = {1};
        new HeapSort().heapSort(s);
        assertArrayEquals(result, s);
    }

    @Test
    public void test3() {
        int[] s = {1, 2};
        int[] result = {1, 2};
        new HeapSort().heapSort(s);
        assertArrayEquals(result, s);
    }

    @Test
    public void test4() {
        int[] s = {2, 1};
        int[] result = {1, 2};
        new HeapSort().heapSort(s);
        assertArrayEquals(result, s);
    }
}
