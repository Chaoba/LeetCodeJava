package com.mushuichuan;

import com.mushuichuan.beans.TreeNode;

/**
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
 * <p>
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”
 * <p>
 * _______6______
 * /              \
 * ___2__          ___8__
 * /      \        /      \
 * 0      _4       7       9
 * /  \
 * 3   5
 * For example, the lowest common ancestor (LCA) of nodes 2 and 8 is 6. Another example is LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.
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
