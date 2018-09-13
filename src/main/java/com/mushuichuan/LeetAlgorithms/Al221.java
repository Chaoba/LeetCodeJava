package com.mushuichuan.LeetAlgorithms;


public class Al221 {

    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0) return 0;

        int max = 0;
        int[][] temp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            temp[i][0] = matrix[i][0] - '0';
            if (max == 0 && matrix[i][0] == '1') max = 1;
        }
        for (int i = 0; i < matrix[0].length; i++) {
            temp[0][i] = matrix[0][i] - '0';
            if (max == 0 && matrix[0][i] == '1') max = 1;
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == '0') continue;
                else {
                    if (temp[i - 1][j - 1] == 0) {
                        temp[i][j] = 1;
                    } else {
                        int step = checkSquare(matrix, i, j, temp[i - 1][j - 1]);
                        temp[i][j] = step;
                        System.out.println("i:" + i + "  j:" + j + "  temp[i][j]:" + temp[i][j]);
                        max = max < temp[i][j] ? temp[i][j] : max;
                    }
                }

            }
        }

        return max * max;
    }

    int checkSquare(char[][] matrix, int i, int j, int step) {
        int maxStep = 1;
        while (step >= maxStep) {
            if (matrix[i][j - maxStep] == '0') break;
            if (matrix[i - maxStep][j] == '0') break;
            maxStep++;
        }
        return maxStep;
    }
}
