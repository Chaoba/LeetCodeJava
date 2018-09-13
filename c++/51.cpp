/**
The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.



Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

Example:

Input: 4
Output: [
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above.
**/
#include <stdio.h>
#include<iostream>
#include <vector>
#include <string> 
using namespace std;
static vector<vector<char> > board =[](){
    std::ios::sync_with_stdio(false);
    cin.tie(NULL);
    return vector<vector<char> >{};
}();
class Solution {
public:
    vector<vector<string> > solveNQueens(int n) {
    	vector<vector<string> > result;
    	string content = "";
    	for(int i = 0; i< n; i++) {
    		content += '.';
    	}
    	vector<string> temp(n, content);
        vector<int> row(n, 0);
        vector<int> col(n, 0);
        vector<int> lef(2 * n-1, 0);
        vector<int> rig(2 * n-1, 0);
        find(result, temp, row, col, lef, rig, 0, 0, n, 0);
        return result;
    }

    void find(vector<vector<string> >& result, vector<string>& temp, vector<int>& row, vector<int>& col, vector<int>& lef, vector<int>& rig, int i, int j, int n, int count) {
    	if(count == n) {
    		vector<string> r = temp;
    		result.push_back(r);
    		return;
    	}
    	if(i == n) return;
    	for(;j< n;j++){
	    	if(findIndex(row, col, lef, rig, i, j, n)) {
	    		temp[i][j] = 'Q';
	    		row[i] = 1;
	    		col[j] = 1;
	    		lef[i + j] = 1;
	    		rig[n + j - i - 1] = 1;
	    		// cout<< i<<"  "<<j<< "  "<<i + j << " "<< n +j - i -1 <<endl;
	    		find(result, temp, row, col, lef, rig, i + 1, 0, n, count + 1);
	    		temp[i][j] = '.';
	    		row[i] = 0;
	    		col[j] = 0;
	    		lef[i + j] = 0;
	    		rig[n + j - i - 1] = 0;
	    	}
	    }
    	return ;
    }

    bool findIndex(vector<int>& row, vector<int>& col, vector<int>& lef, vector<int>& rig, int& i, int& j, int n) {
    	// for(int x = i; x < n ; x++ ) {
    		// if(row[x]) continue;
    		int x = i;
    		for(int y = j; y < n; y++) {
    			if(col[y] ){
    				// if(x > 4){
    				// 		cout<< x<<"===================y in use  "<<y<< "  "<<x+y<< " "<< n +y - x -1 <<endl;
    				// }
    				continue;
    			}else if (lef[ x + y]){
    				// if(x > 4){
    				// 		cout<< x<<"===================lef in use  "<<y<< "  "<<x+y<< " "<< n +y - x -1 <<endl;
    				// }
					continue;
    			} else if(rig[ n + y - x - 1]){
    				// if(x > 4){
    				// 		cout<< x<<"===================rig in use  "<<y<< "  "<<x+y<< " "<< n +y - x -1 <<endl;
    				// }
    				continue;
    			}
    			i = x;
    			j = y;
    			return true;
    		}
    	// }
    	return false;
    }
};


int main(int argc, char** argv) {
	Solution s;
	vector<vector<string> >  result = s.solveNQueens(8);
	cout<< result.size()<<endl;
	// for(auto r : result){
	// 	for(auto t : r) {
	// 		cout<<" "<<t <<endl;
	// 	}
	// 	cout<<"==================="<<endl;
	// }
}