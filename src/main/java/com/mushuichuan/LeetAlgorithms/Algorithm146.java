package com.mushuichuan.LeetAlgorithms;

import java.util.HashMap;

/**
 * 146. LRU Cache  QuestionEditorial Solution  My Submissions
 * Total Accepted: 78995
 * Total Submissions: 498616
 * Difficulty: Hard
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.
 * <p>
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 */
public class Algorithm146 {
    int currentSize = 0;
    int max = 0;
    Node head;
    HashMap<Integer, Node> map = new HashMap<Integer, Node>();

    public Algorithm146(int capacity) {
        max = capacity;
    }


    public int get(int key) {
        if (head == null) {
            return -1;
        } else {
            Node temp = map.get(key);
            if (temp != null) {
                // find the node, move it to head
                if (temp != head) {
                    // remove from current position
                    temp.left.right = temp.right;
                    temp.right.left = temp.left;
                    // add to the head
                    head.left.right = temp;
                    temp.left = head.left;
                    head.left = temp;
                    temp.right = head;
                    head = temp;
                }
                return temp.value;
            } else {
                return -1;
            }
        }
    }

    public void set(int key, int value) {
        if (head == null) {
            // the first one
            head = new Node(key, value);
            head.left = head;
            head.right = head;
            currentSize++;

        } else if (get(key) == -1) {
            // excess the capability
            if (max == currentSize) {
                map.remove(head.left.key);
                head.left.key = key;
                head.left.value = value;
                head = head.left;
            } else {
                // add a new node to the list
                currentSize++;
                Node node = new Node(key, value);
                node.left = head.left;
                node.right = head;
                head.left.right = node;
                head.left = node;
                head = node;
            }
        } else {
            // replace current value
            map.remove(head.key);
            head.value = value;
        }

        map.put(key, head);
    }

    class Node {
        Node left;
        Node right;
        Node next;
        int key;
        int value;

        public Node(int k, int v) {
            key = k;
            value = v;
        }

    }
}
