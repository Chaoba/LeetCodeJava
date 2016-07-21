package com.mushuichuan;

/**
 * 342. Power of Four  QuestionEditorial Solution  My Submissions
 * Total Accepted: 27802
 * Total Submissions: 78599
 * Difficulty: Easy
 * Given an integer (signed 32 bits), write a function to check whether it is a power of 4.
 * <p>
 * Example:
 * Given num = 16, return true. Given num = 5, return false.
 * <p>
 * Follow up: Could you solve it without loops/recursion?
 * Created by Liyanshun on 2016/7/21.
 */
public class Algorithm342 {
    public boolean isPowerOfFour(int num) {
        // if a number is power of 2, then num&(num-1)==0;
        // 5 is 1001, 4 is 1000, 2 is 0010, so if the number is the power of 2 but not 4, num&0x5555555==0;
        // it seems that 0x77777777 work ok too
        return (num & (num - 1)) == 0 && (num & 0x55555555) != 0;
    }
}
