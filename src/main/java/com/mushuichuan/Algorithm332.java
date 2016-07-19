package com.mushuichuan;

import java.util.Arrays;
import java.util.HashMap;

public class Algorithm332 {
	public void test() {
		 int[] c = { 186, 419, 83, 408 };
		 int amount = 6249;
//		int[] c = { 4, 7, 19, 11 };
//		int amount = 50;
		System.out.println(coinChange(c, amount));
	}

	public int coinChange(int[] coins, int amount) {
		HashMap<Integer, Integer> map = new HashMap();
		for (int i = 0; i <= amount; i++)
			map.put(i, amount+1);
		map.put(0, 0);
		for (int coin : coins) {
			for (int j = coin; j <= amount; j++) {
				int temp = map.get(j - coin) + 1;
				int min=Math.min(map.get(j), temp);
				map.put(j, min);
			}
		}
		return map.get(amount) > amount ? -1 :map.get(amount);
	}
}
