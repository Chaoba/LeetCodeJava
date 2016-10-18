package com.mushuichuan.LeetAlgorithms;

/**
 * There are N children standing in a line. Each child is assigned a rating value.
 * <p>
 * You are giving candies to these children subjected to the following requirements:
 * <p>
 * Each child must have at least one candy.
 * Children with a higher rating get more candies than their neighbors.
 * What is the minimum candies you must give?
 */
public class Algorithm135 {
    public int candy(int[] ratings) {
        if (ratings.length <= 1) {
            return ratings.length;
        }
        int[] candys = new int[ratings.length];
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candys[i] = candys[i - 1] + 1;
            }
        }

        for (int i = ratings.length - 1; i > 0; i--) {
            if (ratings[i - 1] > ratings[i]) {
                candys[i - 1] = Math.max(candys[i] + 1, candys[i - 1]);
            }
        }
        int count = 0;
        for (int i = 0; i < candys.length; i++) {
            count += candys[i];
        }
        count += candys.length;
        return count;
    }
}
