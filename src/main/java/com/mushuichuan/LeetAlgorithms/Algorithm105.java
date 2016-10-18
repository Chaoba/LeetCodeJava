package com.mushuichuan.LeetAlgorithms;

import com.mushuichuan.beans.TreeNode;

/**
 * 105. Construct Binary Tree from Preorder and Inorder Traversal  QuestionEditorial Solution  My Submissions
 * Total Accepted: 69371
 * Total Submissions: 235921
 * Difficulty: Medium
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * <p>
 * Note:
 * You may assume that duplicates do not exist in the tree.
 */
public class Algorithm105 {

    int[] preorder;
    int[] inorder;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        this.preorder = preorder;
        this.inorder = inorder;
        TreeNode root = buildTree(0, preorder.length, 0, inorder.length);
        return root;
    }

    public TreeNode buildTree(int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart >= preorder.length) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int center = 0;
        //find the position of root in inorder
        for (int i = inStart; i < inEnd; i++) {
            if (inorder[i] == preorder[preStart]) {
                center = i;
                break;
            }
        }
        int leftNum = center - inStart;
        int rightNum = inEnd - center - 1;
        //create left child tree
        if (leftNum > 0) {
            root.left = buildTree(preStart + 1, preStart + 1 + leftNum, inStart, center);
        }
        //create right child tree
        if (rightNum > 0) {
            root.right = buildTree(preStart + 1 + leftNum, preEnd, center + 1, inEnd);
        }
        return root;
    }


}
