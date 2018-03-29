package com.mushuichuan.LeetAlgorithms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a non-empty list of words, return the k most frequent elements.
 * <p>
 * Your answer should be sorted by frequency from highest to lowest. If two words have the same frequency, then the word with the lower alphabetical order comes first.
 * <p>
 * Example 1:
 * Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
 * Output: ["i", "love"]
 * Explanation: "i" and "love" are the two most frequent words.
 * Note that "i" comes before "love" due to a lower alphabetical order.
 * Example 2:
 * Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
 * Output: ["the", "is", "sunny", "day"]
 * Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
 * with the number of occurrence being 4, 3, 2 and 1 respectively.
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Input words contain only lowercase letters.
 * Follow up:
 * Try to solve it in O(n log k) time and O(n) extra space.
 */
public class Al692 {

    class Trie {
        Trie[] next = new Trie[26];
        String word;
        int count;

        public void insert(String s) {
            Trie current = this;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);

                if (current.next[c - 'a'] == null) {
                    current.next[c - 'a'] = new Trie();
                }

                current = current.next[c - 'a'];
                if (i == s.length() - 1) {
                    current.word = s;
                    current.count++;
                }
            }
        }
    }

    public List<String> topKFrequent(String[] words, int k) {
        Trie trie = new Trie();
        for (String s : words) {
            trie.insert(s);
        }

        List<Integer> max = new LinkedList<>();
        List<Trie> maxNode = new LinkedList<>();

        for (Trie node : trie.next) {
            dfs(node, max, maxNode, k);
        }
        List<String> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            Trie n = maxNode.get(i);
            result.add(n.word);
        }
        return result;
    }

    void dfs(Trie node, List<Integer> max, List<Trie> list, int k) {
        if (node == null) return;
        if (node.word != null) {
            int index = 0;
            for (int i = 0; i < k && i < max.size(); i++) {
                if (max.get(i) < node.count) {
                    index = i;
                    break;
                }
                index = k;
            }
            if(index<max.size()) {
                max.add(index, node.count);
                list.add(index, node);
            }else{
                max.add(node.count);
                list.add(node);
            }
        }
        for (Trie child : node.next) {
            dfs(child, max, list, k);
        }

    }
}
