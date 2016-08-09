"""
112. Path Sum  QuestionEditorial Solution  My Submissions
Total Accepted: 115389
Total Submissions: 361246
Difficulty: Easy
Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
"""
from TreeNode import TreeNode


class Solution(object):
    def hasPathSum(self, root, sum):
        """
        :type root: TreeNode
        :type sum: int
        :rtype: bool
        """
        if not root:
            return False

        if not root.left and not root.right and root.val == sum:
            return True

        sum -= root.val
        return self.hasPathSum(root.left, sum) or self.hasPathSum(root.right, sum)

    def hasPathSum1(self, root, sum):
        """
        :type root: TreeNode
        :type sum: int
        :rtype: bool
        """
        if root is None:
            return False
        return self.colculate(root, 0, sum)

    def colculate(self, root, current, sum):
        val_current = root.val + current
        if val_current == sum and root.left is None and root.right is None:
            return True
        elif root.left is not None and self.colculate(root.left, val_current, sum):
            return True
        elif root.right is not None and self.colculate(root.right, val_current, sum):
            return True
        else:
            return False;
