package com.mushuichuan.LeetAlgorithms;

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * <p>
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * <p>
 * Example 1:
 * nums1 = [1, 3]
 * nums2 = [2]
 * <p>
 * The median is 2.0
 * Example 2:
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * <p>
 * The median is (2 + 3)/2 = 2.5
 * Created by Liyanshun on 2016/7/18.
 */
public class Algorithm4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        /** longer one*/
        int[] m;
        /** short one*/
        int[] n;
        if (nums1.length >= nums2.length) {
            m = nums1;
            n = nums2;
        } else {
            m = nums2;
            n = nums1;
        }
        int min = 0, max = n.length;
        int half = (n.length + m.length + 1) / 2;

        /** longer index*/
        int i = 0;
        /** shorter index*/
        int j = 0;
        while (min <= max) {
            j = (min + max) >> 1;
            i = half - j;
            if (j > 0 && i < m.length && m[i] < n[j - 1]) {
                max = j - 1;
            } else if (i > 0 && j < n.length && n[j] < m[i - 1]) {
                min = j + 1;
            } else {
                int maxLeft = 0, minRight = 0;
                if (j == 0) {
                    maxLeft = m[i - 1];
                } else if (i == 0) {
                    maxLeft = n[j - 1];
                } else {
                    maxLeft = m[i - 1] > n[j - 1] ? m[i - 1] : n[j - 1];
                }

                if ((n.length + m.length) % 2 == 1) {
                    return maxLeft;
                }

                if (j == n.length) {
                    minRight = m[i];
                } else if (i == m.length) {
                    minRight = n[j];
                } else {
                    minRight = m[i] < n[j] ? m[i] : n[j];
                }
                return (minRight + maxLeft) / 2.0;
            }

        }
        return 0;
    }
}
