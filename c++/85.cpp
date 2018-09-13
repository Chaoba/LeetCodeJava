/**

Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

Example:

Input:
[
  ["1","0","1","0","0"],
  ["1","0","1","1","1"],
  ["1","1","1","1","1"],
  ["1","0","0","1","0"]
]
Output: 6
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
    int maximalRectangle(vector<vector<char>>& matrix) {
        int m = matrix.size();
        if(m == 0) return 0;
        int n = matrix[0].size();
        if(n == 0) return 0;

        int maxRect = 0;
        vector<vector<int>> height(m, vector<int>(n + 1, 0));
        for(int i = 0; i < n; i++) {
            height[0][i] = matrix[0][i] - '0';
        }
        for(int i = 1; i < m; i++) {
            for(int j = 0; j < n; j++){
                height[i][j] = matrix[i][j] == '1' ? height[i - 1][j] + matrix[i][j] - '0' : 0;
            }
        }

        for(int i = 0; i < m; i++) {
            int temp = largestRectangleArea(height[i]);
            cout<< i <<"==="<< temp<<endl;
            maxRect = maxRect > temp ? maxRect : temp;
        }
        return maxRect;
    }

    int largestRectangleArea(vector<int>& heights) {

        int ret = 0;
//        heights.push_back(0);
        vector<int> s;

        int i = 0;
        while(i < heights.size()){
            if(s.empty() || heights[i] > heights[s[s.size() - 1]]){
                s.push_back(i++);
            } else {
                int j = s[s.size() - 1];
                s.pop_back();
                int h = heights[j];
                int w = s.empty() ? i : (i - s[s.size() - 1] - 1);
                int rect = h * w;
                ret = ret < rect ? rect : ret;

            }
        }

        return ret;
    }

};

int main() {
	Solution s;
	vector<vector<char>> matrix ={{'0','0','1','0'},{'1','1','1','1'},{'1','1','1','1'},{'1','1','1','0'},{'1','1','0','0'},{'1','1','1','1'},{'1','1','1','0'}};
	cout<< s.maximalRectangle(matrix);
	}