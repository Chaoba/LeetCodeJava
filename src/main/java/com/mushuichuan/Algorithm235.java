package com.mushuichuan;

import com.mushuichuan.beans.TreeNode;

/**
 * Created by Liyanshun on 2016/7/24.
 */
public class Algorithm235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int min = 0;
        int max = 0;
        if (p.val > q.val) {
            max = p.val;
            min = q.val;
        } else {
            max = q.val;
            min = p.val;
        }
        while (root != null) {
            if (root.val > max) {
                root = root.left;
            } else if (root.val < min) {
                root = root.right;
            } else {
                return root;
            }
        }
        return null;
    }
}
