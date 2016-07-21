package com.mushuichuan;

/**
 * 11. Container With Most Water  QuestionEditorial Solution  My Submissions
 * Total Accepted: 85720
 * Total Submissions: 242991
 * Difficulty: Medium
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 * <p>
 * Note: You may not slant the container.
 * Created by Liyanshun on 2016/7/21.
 */
public class Algorithm11 {
    public int maxArea(int[] height) {

        int maxY = 0;
        int left = 0, right = height.length - 1;
        int max = 0;
        while (left < right) {
            maxY = Math.min(height[left], height[right]);
            int temp = (right - left) * maxY;
            if (temp > max) {
                max = temp;
            }
            while (left < right && height[left] <= maxY) {
                left++;
            }
            while (right > left && height[right] <= maxY) {
                right--;
            }
        }
        return max;
    }
}
