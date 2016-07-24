package com.mushuichuan;

import com.mushuichuan.beans.TreeNode;

import java.util.Stack;

/**
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
