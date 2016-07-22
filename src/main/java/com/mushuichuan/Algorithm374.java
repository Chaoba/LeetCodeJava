package com.mushuichuan;

/**
 * 374. Guess Number Higher or Lower  QuestionEditorial Solution  My Submissions
 * Total Accepted: 7722
 * Total Submissions: 24493
 * Difficulty: Easy
 * We are playing the Guess Game. The game is as follows:
 * <p>
 * I pick a number from 1 to n. You have to guess which number I picked.
 * <p>
 * Every time you guess wrong, I'll tell you whether the number is higher or lower.
 * <p>
 * You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):
 * <p>
 * -1 : My number is lower
 * 1 : My number is higher
 * 0 : Congrats! You got it!
 * Example:
 * n = 10, I pick 6.
 * <p>
 * Return 6.
 * Created by Liyanshun on 2016/7/22.
 */
public class Algorithm374 {
    private int num;

    public int guessNumber(int n) {
        int begin = 1;
        int end = n;
        do {
            int mid = begin + ((end - begin) >> 1);
            int gue = guess(mid);
            if (gue == 1) {
                begin = mid + 1;
            } else if (gue == -1) {
                end = mid - 1;
            } else {
                return mid;
            }
        } while (begin <= end);
        return -1;
    }

    public void setGuess(int num) {
        this.num = num;
    }

    int guess(int i) {
        if (i == num) {
            return 0;
        } else if (i < num) {
            return 1;
        } else {
            return -1;
        }
    }
}
