package com.mushuichuan.LeetAlgorithms;

import java.util.Stack;

public class Algorithm803 {
    public int[] hitBricks(int[][] grid, int[][] hits) {
        int total = 0;
        int[] result = new int[hits.length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                total = grid[i][j] == 1 ? total + 1 : total;
            }
        }

        System.out.println("total:" + total);
        for (int j = 0; j < hits.length; j++) {
            if(grid[hits[j][0]][hits[j][1]]==1) {
                grid[hits[j][0]][hits[j][1]] = 0;
                int count = 0;
                int[][] visited = new int[grid.length][grid[0].length];
                System.out.println("jjj:" + j);
                for (int i = 0; i < grid[0].length; i++) {
                    if (grid[0][i] == 1 && visited[0][i] == 0) {
                        count += findNum(0, i, grid, visited);
                        System.out.println("i:" + i + "  count: " + count);

                    }
                }
                int r = total - count - 1;
                result[j] = r > 0 ? r : 0;
                total = count;
            }
        }


        return result;
    }


    class Node {
        int i;
        int j;

        public Node(int x, int y) {
            i = x;
            j = y;
        }
    }

    public int findNum(int i, int j, int[][] grid, int[][] visited) {
        Stack<Node> stack = new Stack<>();
        stack.push(new Node(i, j));
        int count = 0;
        while (!stack.empty()) {
            Node node = stack.pop();
            count++;
            System.out.println("x:"+node.i+"  y:"+node.j);
            visited[node.i][node.j] = 1;

            if (node.j - 1 >= 0 && grid[node.i][node.j - 1] == 1 && visited[node.i][node.j - 1] == 0) {
                stack.push(new Node(node.i, node.j - 1));
            }
            if (node.j + 1 < grid[0].length && grid[node.i][node.j + 1] == 1 && visited[node.i][node.j + 1] == 0) {
                stack.push(new Node(node.i, node.j + 1));
            }

            if (node.i + 1 < grid.length && grid[node.i + 1][node.j] == 1 && visited[node.i + 1][node.j] == 0) {
                stack.push(new Node(node.i + 1, node.j));
            }
        }

        return count;
    }
}
