package com.mushuichuan.LeetAlgorithms;

import java.util.HashMap;

/**
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 * <p>
 * For example,
 * S = "ADOBECODEBANC"
 * T = "ABC"
 * Minimum window is "BANC".
 * <p>
 * Note:
 * If there is no such window in S that covers all characters in T, return the empty string "".
 * <p>
 * If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
 */
public class Algorithm76 {

    public String minWindow(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0 || t.length() > s.length()) {
            return "";
        }
        HashMap<Character, Integer> map = new HashMap();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        int begin = 0, end = 0, head = 0, count = t.length();
        int minLen = Integer.MAX_VALUE;
        while (end < s.length()) {
            char c = s.charAt(end);
            if (map.containsKey(c)) {
                //find a matching character
                if (map.get(c) > 0) {
                    count--;
                }
                map.put(c, map.get(c) - 1);
            }
            end++;
            while (count == 0) {
                // find a matching substring
                if (end - begin < minLen) {
                    minLen = end - begin;
                    head = begin;
                }
                char sta = s.charAt(begin);
                if (map.containsKey(sta)) {
                    int slen = map.get(sta) + 1;
                    map.put(sta, slen);
                    if (slen > 0) {
                        count++;
                    }
                }

                begin++;
            }
        }
//		System.out.println("head:" + head + " len:" + minLen);
        if (minLen != Integer.MAX_VALUE) {
            return s.substring(head, head + minLen);
        } else {
            return "";
        }
    }
}
