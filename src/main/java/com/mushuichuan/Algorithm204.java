package com.mushuichuan;

/**
 * 204. Count Primes  QuestionEditorial Solution  My Submissions
 * Total Accepted: 72339
 * Total Submissions: 287074
 * Difficulty: Easy
 * Description:
 * <p>
 * Count the number of prime numbers less than a non-negative number, n.
 */
public class Algorithm204 {
    public void test() {
        System.out.println(countPrimes(4));
    }

    public int countPrimes(int n) {
        boolean[] noPrime = new boolean[n];
        for (int i = 2; i * i <= n; i++) {
            if (noPrime[i])
                continue;
            for (int j = i * i; j < n; j += i) {
                noPrime[j] = true;
            }
        }

        int num = 0;
        for (int i = 2; i < n; i++) {
            if (!noPrime[i]) {
                num++;
            }
        }
        return num;
    }

}
