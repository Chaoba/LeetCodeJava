package com.mushuichuan;

/**
 * 278. First Bad Version  QuestionEditorial Solution  My Submissions
 * Total Accepted: 52688
 * Total Submissions: 228829
 * Difficulty: Easy
 * You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.
 * <p>
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.
 * <p>
 * You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.
 * Created by Liyanshun on 2016/7/11.
 */
public class Algorithm278 {
    public int firstBadVersion(int n) {
        int begin = 1, end = n;
        while (begin <= end) {
            int middle = (begin + end) / 2;
            if (isBadVersion(middle)) {
                if (!isBadVersion(middle - 1)) {
                    return middle;
                } else {
                    end = middle - 1;
                }
            } else {
                if (isBadVersion(middle + 1)) {
                    return middle + 1;
                } else {
                    begin = middle + 1;
                }
            }
        }
        return -1;
    }

    private boolean isBadVersion(int middle) {
        return false;
    }
}
