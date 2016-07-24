package com.mushuichuan;

import com.mushuichuan.beans.TreeNode;

import java.util.Stack;

/**
 * 230. Kth Smallest Element in a BST  QuestionEditorial Solution  My Submissions
 * Total Accepted: 56155
 * Total Submissions: 143050
 * Difficulty: Medium
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 * <p>
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 * Created by Liyanshun on 2016/7/24.
 */
public class Algorithm230 {
    public int kthSmallest(TreeNode root, int k) {
        int index = 0;
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.empty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
                continue;
            } else {
                root = stack.pop();
                index++;
                if (index == k) {
                    return root.val;
                }
                root = root.right;

            }
        }
        return 0;
    }
}
