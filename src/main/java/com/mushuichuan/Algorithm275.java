package com.mushuichuan;

/**
 *  Follow up for H-Index: What if the citations array is sorted in ascending order? Could you optimize your algorithm?
 * <p>
 * Created by Liyanshun on 2016/7/19.
 */
public class Algorithm275 {
    public int hIndex(int[] citations) {
        int len = citations.length;
        int start = 0;
        int end = len - 1;
        while (start <= end) {
            int i = (start + end) / 2;
            if (citations[i] >= len - i) {
                end = i - 1;
            } else {
                start = i + 1;
            }
        }

        return len - start;
    }
}
