package com.mushuichuan.LeetAlgorithms;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Algorithm805 {

    public boolean check(int[] A, int leftSum, int leftNum, int startIndex) {
        if (leftNum == 0) return leftSum == 0;
        if ((A[startIndex]) > leftSum / leftNum) return false;
        for (int i = startIndex; i < A.length - leftNum + 1; i++) {
            if (i > startIndex && A[i] == A[i - 1]) continue;
            if (check(A, leftSum - A[i], leftNum - 1, i + 1)) return true;
        }
        return false;
    }

    public boolean splitArraySameAverage(int[] A) {
        int total = 0;
        for (int i = 0; i < A.length; i++) {
            total += A[i];
        }

        Arrays.sort(A);
        for (int i = 1; i <= A.length / 2; i++) {
            if ((total * i) % A.length == 0) {
                if (check(A, total * i / A.length, i, 0)) return true;
            }

        }

        return false;
    }

}
