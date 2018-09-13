/**
Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?

Example:

Input: 3
Output: 5
Explanation:
Given n = 3, there are a total of 5 unique BST's:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
   **/
#include <stdio.h>
#include<iostream>
#include <vector>
#include <stack>
#include <string>
using namespace std;


static vector<vector<char> > board =[](){
    std::ios::sync_with_stdio(false);
    cin.tie(NULL);
    return vector<vector<char> >{};
}();
class Solution {
public:
    int numTrees(int n) {
        vector<int> nums(n + 1, 0);
        nums[0] = 1;
        nums[1] = 1;
        nums[2] = 2;
        for(int i = 3; i<= n; i++) {
            for(int j = 1; j<=i; j++) {
                    nums[i] += nums[i - j] * nums[j - 1];

            }

        }

        return nums[n];
    }
};


int main() {
	Solution s;
	cout<<s.numTrees(6)<<endl;
}