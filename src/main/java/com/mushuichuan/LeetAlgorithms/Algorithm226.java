package com.mushuichuan.LeetAlgorithms;

import com.mushuichuan.beans.TreeNode;

import java.util.Stack;

/**
 * 226. Invert Binary Tree  QuestionEditorial Solution  My Submissions
 * Total Accepted: 106501
 * Total Submissions: 226039
 * Difficulty: Easy
 * Invert a binary tree.
 * <p>
 * 4
 * /   \
 * 2     7
 * / \   / \
 * 1   3 6   9
 * to
 * 4
 * /   \
 * 7     2
 * / \   / \
 * 9   6 3   1
 * Created by Liyanshun on 2016/7/24.
 */
public class Algorithm226 {
    public TreeNode invertTree(TreeNode root) {
        if (root != null) {
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            invertTree(root.left);
            invertTree(root.right);
        }
        return root;
    }
}
