/**

Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.


In Pascal's triangle, each number is the sum of the two numbers directly above it.

Example:

Input: 5
Output:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
Seen this question in a real interview before?  YesNo
Difficulty:Easy
Total Accepted:184.8K
Total Submissions:446.9K
Contributor:LeetCode
Subscribe to see which companies asked this question.

Related Topics
Array
Similar Questions
Pascal's Triangle II
C++
**/

class Solution {
public:
    vector<vector<int> > generate(int numRows) {
        vector<vector<int> > r;
        for(int i = 0; i < numRows; i++ ){
            vector<int> v( i+1, 1);
            for(int j = 1; j < i ; j++){
                v[j] = r[i - 1][j - 1] + r[i - 1][j];
            }
            r.push_back(v);
        }

        return r[r.size() - 1];
    }
};