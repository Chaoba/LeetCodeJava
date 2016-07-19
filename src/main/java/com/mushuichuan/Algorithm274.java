package com.mushuichuan;

/**
 * Created by Liyanshun on 2016/7/19.
 */
public class Algorithm274 {
    public int hIndex(int[] citations) {
        int[] temp = new int[citations.length + 1];
        for (int c : citations) {
            if (c > citations.length) {
                temp[citations.length]++;
            } else {
                temp[c]++;
            }
        }
        int total = 0;
        for (int i = citations.length; i >= 0; i--) {
            total += temp[i];
            if (total >= i) {
                return i;
            }
        }
        return 0;
    }
}
