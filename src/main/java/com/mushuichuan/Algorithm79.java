package com.mushuichuan;

/**
 * Given a 2D board and a word, find if the word exists in the grid.
 * <p>
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
 * <p>
 * For example,
 * Given board =
 * <p>
 * [<p>
 * ['A','B','C','E'],<p>
 * ['S','F','C','S'],<p>
 * ['A','D','E','E']<p>
 * ]<p>
 * word = "ABCCED", -> returns true,<p>
 * word = "SEE", -> returns true,<p>
 * word = "ABCB", -> returns false.<p>
 */
public class Algorithm79 {
    char[] list;
    boolean[][] visited;
    char[][] board;

    public boolean exist(char[][] board, String word) {
        this.board = board;
        list = word.toCharArray();
        visited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                char c = board[i][j];
                if (c == list[0]) {
                    visited[i][j] = true;
                    visited[i][j] = check(list, 1, i + 1, j) || check(list, 1, i - 1, j) || check(list, 1, i, j + 1)
                            || check(list, 1, i, j - 1);
                    if (visited[i][j]) {
                        return true;
                    }

                }
            }
        }
        return false;
    }

    boolean check(char[] list, int index, int i, int j) {
        if (index == list.length) {
            return true;
        }
        if (index < 0 || i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j]) {
            return false;
        }
        if (list[index] == board[i][j]) {
            visited[i][j] = true;
            visited[i][j] = check(list, index + 1, i + 1, j) || check(list, index + 1, i - 1, j)
                    || check(list, index + 1, i, j + 1) || check(list, index + 1, i, j - 1);
            return visited[i][j];
        } else {
            return false;
        }
    }
}
