package com.mushuichuan;

import com.mushuichuan.beans.TreeNode;

/**
 * 222. Count Complete Tree Nodes  QuestionEditorial Solution  My Submissions
 * Total Accepted: 38381
 * Total Submissions: 147905
 * Difficulty: Medium
 * Given a complete binary tree, count the number of nodes.
 * <p>
 * Definition of a complete binary tree from Wikipedia:
 * In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
 * Created by Liyanshun on 2016/7/24.
 */
public class Algorithm222 {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = leftDepth(root.left);
        int right = leftDepth(root.right);
        if (left == right) {
            //the left child is a complete tree
            return (1 << left) + countNodes(root.right);
        } else {
            //the right child is a complete tree
            return (1 << right) + countNodes(root.left);
        }
    }

    private int leftDepth(TreeNode root) {
        int count = 0;
        while (root != null) {
            root = root.left;
            count++;
        }
        return count;
    }


    public int countNodes1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return countNodes1(root.left) + countNodes1(root.right) + 1;
    }
}
