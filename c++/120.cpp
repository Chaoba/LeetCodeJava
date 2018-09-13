/**
Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle

[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

Note:

Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.

Seen this question in a real interview before?  YesNo
Difficulty:Medium
Total Accepted:141.3K
Total Submissions:394.3K
Contributor:LeetCode
Subscribe to see which companies asked this question.

Related Topics
ArrayDynamic Programming
C++
**/

class Solution {
public:
    int minimumTotal(vector<vector<int>>& triangle) {
        if(triangle.size() == 0) return 0;
        if(triangle.size() == 1) return triangle[0][0];
        int minV = INT_MAX;
        for(int i = 1; i< triangle.size(); i++) {
            int n = triangle[i].size();
            triangle[i][0] += triangle[i - 1][0];
            triangle[i][n - 1] +=triangle[i - 1][n - 2];
            int tempMin = min(triangle[i][0],triangle[i][n - 1]);
            for(int j = 1; j < n - 1; j++){
                triangle[i][j] += min(triangle[i - 1][j - 1], triangle[i - 1][j]);
                if(i == triangle.size() -1){
                    minV = min(triangle[i][j], minV);
                }
            }
            if(i == triangle.size() -1){
                minV = min(tempMin, minV);
            }
        }

        return minV;
    }

    int min(int a, int b){
        return a < b ? a : b；
    }
};