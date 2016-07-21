package com.mushuichuan;

/**
 * 50. Pow(x, n)  QuestionEditorial Solution  My Submissions
 * Total Accepted: 99329
 * Total Submissions: 358820
 * Difficulty: Medium
 * Implement pow(x, n).
 * Created by Liyanshun on 2016/7/11.
 */
public class Algorithm50 {
    public String test() {
        return "" + myPow(3, -2);
    }

    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        double temp = myPow(x, n / 2);
        if (n % 2 == 0) {
            return temp * temp;
        } else {
            if (n < 0) {
                return temp * temp / x;
            } else {
                return x * temp * temp;
            }
        }

    }

}
