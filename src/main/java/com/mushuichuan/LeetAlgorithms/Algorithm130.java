package com.mushuichuan.LeetAlgorithms;

/**
 * 130. Surrounded Regions  QuestionEditorial Solution  My Submissions
 * Total Accepted: 57782
 * Total Submissions: 349570
 * Difficulty: Medium
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
 * <p>
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 * <p>
 * For example,
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * After running your function, the board should be:
 * <p>
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 */
public class Algorithm130 {

    boolean[][] live;
    Position[] stack;
    int top = -1;

    public void solve(char[][] board) {
        if (board.length == 0) {
            return;
        }
        live = new boolean[board.length][board[0].length];
        stack = new Position[board.length * board[0].length];
        for (int i = 0; i < board.length; i++) {
            //no need to find if the start point is unanble
            if (checkEnable(board, i, 0))
                find(board, i, 0);
            if (checkEnable(board, i, board[0].length - 1))
                find(board, i, board[0].length - 1);
        }
        for (int j = 1; j < board[0].length - 1; j++) {
            if (checkEnable(board, 0, j))
                find(board, 0, j);
            if (checkEnable(board, board.length - 1, j))
                find(board, board.length - 1, j);
        }
        for (int i = 0; i < live.length; i++) {
            for (int j = 0; j < live[0].length; j++) {
                if (board[i][j] == 'O' && !live[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    void find(char[][] board, int i, int j) {
        top = -1;
        int x = i, y = j;

        do {
            if (top > -1) {
                Position p = stack[top--];
                x = p.x;
                y = p.y;
            }

            if (checkEnable(board, x - 1, y)) {
                inStack(board, x, y);
                // continue to find next
                inStack(board, x - 1, y);

                x = x - 1;
                continue;

            } else if (checkEnable(board, x + 1, y)) {
                inStack(board, x, y);
                inStack(board, x + 1, y);
                x = x + 1;
                continue;

            } else if (checkEnable(board, x, y - 1)) {
                inStack(board, x, y);
                inStack(board, x, y - 1);
                y = y - 1;
                continue;

            } else if (checkEnable(board, x, y + 1)) {
                inStack(board, x, y);
                inStack(board, x, y + 1);
                y = y + 1;
                continue;
            } else {
                live[x][y] = true;
            }

        } while (top > -1);

    }

    private char inStack(char[][] board, int x, int y) {
        char temp;
        live[x][y] = true;
        stack[++top] = new Position(x, y);
        temp = board[x][y];
        return temp;
    }

    /**
     * check whether the item at this position is an enable '0'
     */
    boolean checkEnable(char[][] board, int x, int y) {
        boolean enable = (x >= 0 && x < board.length && y >= 0 && y < board[0].length && !live[x][y] && board[x][y] == 'O');
//		System.out.println("x:"+x+" y:"+y+ ":"+enable);
        return enable;
    }

    class Position {
        int x, y;

        public Position(int i, int j) {
            x = i;
            y = j;
        }
    }
}
