package com.mushuichuan;

import com.mushuichuan.beans.TreeNode;

/**
 * 114. Flatten Binary Tree to Linked List  QuestionEditorial Solution  My Submissions
 * Total Accepted: 88704
 * Total Submissions: 279242
 * Difficulty: Medium
 * Given a binary tree, flatten it to a linked list in-place.
 * <p>
 * For example,
 * Given
 * <p>
 *      1<p>
 *     / \<p>
 *    2   5<p>
 *   / \   \<p>
 * 3    4    6<p>
 * The flattened tree should look like:
 * 1<p>
 * \<p>
 * 2<p>
 * \<p>
 * 3<p>
 * \<p>
 * 4<p>
 * \<p>
 * 5<p>
 * \<p>
 * 6<p>
 * click to show hints.
 * <p>
 * Hints:
 * If you notice carefully in the flattened tree, each node's right child points to the next node of a pre-order trav
 */
public class Algorithm114 {

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        StackItem head = null;
        TreeNode tag = root;
        do {
            if (tag.left != null) {
                // store the right and move left to right
                if (tag.right != null) {
                    head = new StackItem(tag.right, head);
                }
                tag.right = tag.left;
                tag.left = null;
                tag = tag.right;
            } else if (tag.right != null) {
                tag.left = null;
                tag = tag.right;
            } else {
                // now in leaf node, get the last right node
                if (head != null) {
                    StackItem item = head;
                    tag.right = item.content;
                    tag.left = null;
                    head = item.next;
                    item.next = null;
                    tag = tag.right;
                } else {
                    tag = null;
                }
            }

        } while (head != null || tag != null);
    }

    class StackItem {
        TreeNode content;
        StackItem next;

        public StackItem(TreeNode node, StackItem head) {
            content = node;
            if (head != null) {
                next = head;
            }
        }
    }

}
