package com.mushuichuan.LeetAlgorithms;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Given a list of strings words representing an English Dictionary, find the longest word in words that can be built one character at a time by other words in words.
 * If there is more than one possible answer, return the longest word with the smallest lexicographical order.
 * <p>
 * If there is no answer, return the empty string.
 * Example 1:
 * Input:
 * words = ["w","wo","wor","worl", "world"]
 * Output: "world"
 * Explanation:
 * The word "world" can be built one character at a time by "w", "wo", "wor", and "worl".
 * Example 2:
 * Input:
 * words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
 * Output: "apple"
 * Explanation:
 * Both "apply" and "apple" can be built from other words in the dictionary. However, "apple" is lexicographically smaller than "apply".
 * Note:
 * <p>
 * All the strings in the input will only contain lowercase letters.
 * The length of words will be in the range [1, 1000].
 * The length of words[i] will be in the range [1, 30].
 */
public class Al720 {

    public String longestWord(String[] words) {
        Arrays.sort(words);
        HashSet<String> set = new HashSet<>();
        String result = "";

        for (String s : words) {
            if (s.length() == 1 || set.contains(s.substring(0, s.length() - 1))) {
                if (s.length() > result.length()) {
                    result = s;
                }
                set.add(s);
            }
        }
        return result;

    }

    //Trie + DFS traversal trie
    //Time: O(n * wL); Space : O(n * wL)

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word;
    }

    class Trie {
        TrieNode root;
        Trie() {
            root = new TrieNode();
            root.word = "";
        }
        public void addWord(String w) {
            TrieNode ws = root;
            for(char c : w.toCharArray()){
                if(ws.children[c - 'a'] == null) ws.children[c - 'a'] = new TrieNode();
                ws = ws.children[c - 'a'];
            }
            ws.word = w;
        }
    }



    public String longestWord1(String[] words) {
        //build trie
        Trie trie = new Trie();
        for(String w : words) trie.addWord(w);
        //DFS Traverse Trie
        String[] res = new String[]{""};
        dfs(trie.root, res);
        return res[0];
    }

    public void dfs(TrieNode root, String[] res) {
        if(root.word == null) return;
        if(root.word.length() > res[0].length()) res[0] = root.word;
        for(TrieNode child : root.children){//from 'a' to 'z' to make sure the smallest lexicographical order
            if(child != null) dfs(child, res);
        }
    }
}
