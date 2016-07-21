package com.mushuichuan;

import com.mushuichuan.beans.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
 * <p>
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * return its bottom-up level order traversal as:
 * [
 * [15,7],
 * [9,20],
 * [3]
 * ]
 * Created by Liyanshun on 2016/7/11.
 */
public class Algorithm107 {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new ArrayList();
        if (root == null) {
            return list;
        }
        TreeNode[] stack1 = new TreeNode[1000];
        int top1 = -1;
        TreeNode[] stack2 = new TreeNode[1000];
        int top2 = -1;
        stack1[++top1] = root;
        while (top1 > -1) {
            List<Integer> subList = new ArrayList();
            while (top1 > -1) {
                stack2[++top2] = stack1[top1--];
            }
            while (top2 > -1) {
                TreeNode node = stack2[top2--];
                subList.add(node.val);
                if (node.left != null) {
                    stack1[++top1] = node.left;
                }
                if (node.right != null) {
                    stack1[++top1] = node.right;
                }

            }
            list.add(0, subList);
        }
        return list;
    }
}
