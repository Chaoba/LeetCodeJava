/**
Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
Example 1:

Input:
    2
   / \
  1   3
Output: true
Example 2:

    5
   / \
  1   4
     / \
    3   6
Output: false
Explanation: The input is: [5,1,4,null,null,3,6]. The root node's value
             is 5 but its right child's value is 4.
             **/
 struct TreeNode {
      int val;
      TreeNode *left;
      TreeNode *right;
      TreeNode(int x) : val(x), left(NULL), right(NULL) {}

class Solution {
     vector<int> v;

public:
    bool isValidBST(TreeNode* root) {
        if(!root) return 1;
        return helper(root);
    }

    bool helper(TreeNode* node){
        if(node->left) {
            if(!helper(node->left)) return false;
        }
        if(v.size() == 1 && node->val <= v[0]){
            return false;
        }
        if(v.size() == 0){
            v.push_back(node->val);
        } else{
            v[0] = node->val;
        }
        if(node->right) {
            if(!helper(node->right)) return false;
        }
        return true;
    }
};