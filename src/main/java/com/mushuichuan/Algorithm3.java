package com.mushuichuan;

import java.util.HashMap;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 * <p>
 * Examples:
 * <p>
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * <p>
 * Given "bbbbb", the answer is "b", with the length of 1.
 * <p>
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * Created by Liyanshun on 2016/7/18.
 */
public class Algorithm3 {
    byte[] flags = new byte[256];

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        char[] cs = s.toCharArray();
        int max = 0, position = 0;
        resetFlags();

        while (position < cs.length - max) {
            char lastChar = 0;
            int tempMax = 0;
            for (int i = position; i < cs.length; i++) {
                if (flags[cs[i]] == 0) {
                    flags[cs[i]] = 1;
                    lastChar = cs[i];
                    tempMax++;
                    position++;
                } else {

                    if (lastChar == cs[i]) {

                    } else {
                        position = position - tempMax + 1;
                    }
                    resetFlags();
                    break;
                }
                if (tempMax > max) {
                    max = tempMax;
                }
            }
        }
        return max;
    }

    void resetFlags() {
        for (int i = 0; i < 256; i++) {
            flags[i] = 0;
        }
    }

    public int lengthOfLongestSubstring1(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        } else if (s.length() == 1) {
            return 1;
        }
        char[] c = s.toCharArray();
        int index = 0;
        int search = 1;
        int max = 0;
        int tempMax;
        /* key:char; value:position*/
        HashMap<Character, Integer> map = new HashMap<>();
        map.put(c[index], 0);
        while (search < s.length()) {
            if (map.containsKey(c[search])) {
                //find duplicate char
                tempMax = search - index;
                max = tempMax > max ? tempMax : max;
                int newIndex = map.get(c[search]) + 1;
                //remove chars above newIndex
                while (index < newIndex) {
                    map.remove(c[index]);
                    index++;
                }

                index = newIndex;
                if (!map.containsKey(c[index])) {
                    //those continues chars will be removed in above circle, so add it.
                    map.put(c[index], index);
                }
            }
            map.put(c[search], search);

            search++;
        }

        //last check
        tempMax = search - index;
        max = tempMax > max ? tempMax : max;
        return max;
    }
}
