package com.mushuichuan;

/**
 * Created by Liyanshun on 2016/7/22.
 */
public class Algorithm283 {
    public void moveZeroes(int[] nums) {
        int zeroIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                //find the first zero
                if (zeroIndex == -1) {
                    zeroIndex = i;
                }
            } else {
                if (zeroIndex > -1) {
                    //already found zero before
                    nums[zeroIndex] = nums[i];
                    nums[i] = 0;
                    zeroIndex++;
                }
            }
        }
    }
}
