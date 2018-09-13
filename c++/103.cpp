/**
Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
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
    vector<vector<int>> zigzagLevelOrder(TreeNode* root) {
        vector<vector<int>> result;
        if(root) {
            queue<TreeNode*> q;
            q.push(root);
            bool reve = false;
            while(!q.empty()) {
                vector<int> temp;
                int n = q.size();
                while(n > 0){
                    TreeNode* node = q.front();
                    q.pop();
                    temp.push_back(node->val);
                    if(node->left){
                        q.push(node->left);
                    }
                    if(node->right) {
                        q.push(node->right);
                    }
                    n--;
                }
                if(reve){
                    reverse(temp.begin(), temp.end());
                }
                reve = -reve;
                result.push_back(temp);
            }

        }
        return result;
    }
};
//[[3],[20,9],[15,7],[5,4,3,2],[65,8,6,61,67,3,4]]

//[[3],[20,9],[15,7],[5,4,3,2],[3,4,61,67,8,6,65]]