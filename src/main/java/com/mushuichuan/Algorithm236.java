package com.mushuichuan;

import com.mushuichuan.beans.TreeNode;

/**
 * Created by Liyanshun on 2016/7/24.
 */
public class Algorithm236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        } else {
            return right == null ? left : right;
        }
    }


}
