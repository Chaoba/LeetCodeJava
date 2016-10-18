package com.mushuichuan.LeetAlgorithms;

/**
 * Created by Liyanshun on 2016/7/22.
 */
public class Algorithm200 {
    char[][] grid;
    int[][] stack;
    int top = -1;

    public int numIslands(char[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        this.grid = grid;

        stack = new int[grid.length * grid[0].length][2];

        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    //save the position
                    pushStack(i, j);
                }

                while (top > -1) {
                    int m = stack[top][0];
                    int n = stack[top][1];
                    if (isUncheckedLand(m + 1, n)) {
                        pushStack(m + 1, n);
                    } else if (isUncheckedLand(m - 1, n)) {
                        pushStack(m - 1, n);
                    } else if (isUncheckedLand(m, n + 1)) {
                        pushStack(m, n + 1);
                    } else if (isUncheckedLand(m, n - 1)) {
                        pushStack(m, n - 1);
                    } else {
                        //there is no unchecked land around this land, pop
                        top--;
                        if (top == -1) {
                            //find a island
//                            System.out.println("find a land:" + stack[top + 1][0] + ":" + stack[top + 1][1]);
                            count++;
                        }
                    }
                }

            }
        }
        return count;
    }

    private void pushStack(int i, int j) {
//        System.out.println("pushstack:" + i + ":" + j);
        stack[++top][0] = i;
        stack[top][1] = j;
        grid[i][j]=0;
    }

    private boolean isUncheckedLand(int i, int j) {
        return (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == '1');
    }
}
