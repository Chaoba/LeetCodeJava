package com.mushuichuan;

import java.util.HashMap;

/**
 * 322. Coin Change  QuestionEditorial Solution  My Submissions
 * Total Accepted: 28748
 * Total Submissions: 113339
 * Difficulty: Medium
 * You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
 * <p>
 * Example 1:
 * coins = [1, 2, 5], amount = 11
 * return 3 (11 = 5 + 5 + 1)
 * <p>
 * Example 2:
 * coins = [2], amount = 3
 * return -1.
 * <p>
 * Note:
 * You may assume that you have an infinite number of each kind of coin.
 */
public class Algorithm322 {

    public int coinChange(int[] coins, int amount) {
        HashMap<Integer, Integer> map = new HashMap();
        for (int i = 0; i <= amount; i++)
            map.put(i, amount + 1);
        map.put(0, 0);
        for (int coin : coins) {
            for (int j = coin; j <= amount; j++) {
                int temp = map.get(j - coin) + 1;
                int min = Math.min(map.get(j), temp);
                map.put(j, min);
            }
        }
        return map.get(amount) > amount ? -1 : map.get(amount);
    }
}
