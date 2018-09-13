/**
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
**/
#include <stdio.h>
#include<iostream>
#include <vector>
#include <stack>
#include <string>
#include <queue>
using namespace std;


static vector<vector<char> > board =[](){
    std::ios::sync_with_stdio(false);
    cin.tie(NULL);
    return vector<vector<char> >{};
}();
  struct TreeNode {
      int val;
      TreeNode *left;
      TreeNode *right;
      TreeNode(int x) : val(x), left(NULL), right(NULL) {}
  };
class Solution {
public:
    vector<vector<int>> levelOrder(TreeNode* root) {
        vector<vector<int>>result;
        if(root){
            queue<TreeNode*> q;
            q.push(root);

            int n = 1;
            int sub_n = 0;
            int child_count = 0;
            vector<int> temp;

            while(n > 0){
                TreeNode* t= q.front();
                q.pop();
                temp.push_back(t->val);
                sub_n++;

                if(t->left){
                    q.push(t->left);
                    child_count++;
                }
                if(t->right){
                    q.push(t->right);
                    child_count++;
                }

                if(sub_n == n){
                    vector<int> v = temp;
                    result.push_back(v);
                    temp.clear();
                    n = child_count;
                    child_count = 0;
                }

            }
        }

        return result;
    }
};