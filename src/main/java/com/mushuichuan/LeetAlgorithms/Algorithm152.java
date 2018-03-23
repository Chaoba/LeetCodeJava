package com.mushuichuan.LeetAlgorithms;

import static java.lang.Math.max;
import static java.lang.Math.min;

/**
 * Find the contiguous subarray within an array (containing at least one number) which has the largest product.
 * <p>
 * For example, given the array [2,3,-2,4],
 * the contiguous subarray [2,3] has the largest product = 6.
 */
public class Algorithm152 {
    public int maxProduct(int[] nums) {
       int max=nums[0];
       int min =max;
       int result = max;

       for(int i =1;i<nums.length;i++){
           if(nums[i]<0){
               int temp = max;
               max=min;
               min =temp;
           }

           max = Math.max(nums[i], max * nums[i]);
           min = Math.min(nums[i], min * nums[i]);

           result = Math.max(max, result);
       }
       return result;
    }


//    int maxProduct(int A[], int n) {
//        // store the result that is the max we have found so far
//        int r = A[0];
//
//        // imax/imin stores the max/min product of
//        // subarray that ends with the current number A[i]
//        for (int i = 1, imax = r, imin = r; i < n; i++) {
//            // multiplied by a negative makes big number smaller, small number bigger
//            // so we redefine the extremums by swapping them
//            if (A[i] < 0)
//                swap(imax, imin);
//
//            // max/min product for the current number is either the current number itself
//            // or the max/min by the previous number times the current one
//            imax = max(A[i], imax * A[i]);
//            imin = min(A[i], imin * A[i]);
//
//            // the newly computed max value is a candidate for our global result
//            r = max(r, imax);
//        }
//        return r;
//    }
}
