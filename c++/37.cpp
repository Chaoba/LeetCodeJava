/**
Write a program to solve a Sudoku puzzle by filling the empty cells.

A sudoku solution must satisfy all of the following rules:

Each of the digits 1-9 must occur exactly once in each row.
Each of the digits 1-9 must occur exactly once in each column.
Each of the the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
Empty cells are indicated by the character '.'.
**/
#include <stdio.h>
#include<iostream>
#include <vector>
#include <string> 
using namespace std;
static vector<vector<char>> board =[](){
    std::ios::sync_with_stdio(false);
    cin.tie(NULL);
    return vector<vector<char>>{};
}();
class Solution {
public:
    void solveSudoku(vector<vector<char> >& board) {
    	int nums[]={1,2,3,4,5,6,7,8,9};
        vector<vector<int> > row(9, vector<int>());
        vector<vector<int> > col(9, vector<int>());
        vector<vector<int> > block(9, vector<int>());

        for(int i = 0; i< 9; i++) {
        	row[i].insert(row[i].begin(), nums, nums + 9);
	        col[i].insert(col[i].begin(), nums,  nums + 9);
	        block[i].insert(block[i].begin(), nums,  nums + 9);
        }
     
 
        for(int i = 0; i< 9; i++) {
        	for(int j = 0; j < 9; j++) {
        		if(board[i][j] != '.') {
        			int num = board[i][j] - '0';
					row[i][num - 1] = 0;
					block[i / 3 * 3 + j / 3][num - 1] = 0;
					col[j][num - 1] = 0;
        		}
        	}
        }

        bool result = find(board, row, col, block, 0, 0);
        cout<<"result:"<<result<<endl;
    }

    bool find(vector<vector<char> >& board, vector<vector<int> > & row, vector<vector<int> > & col, vector<vector<int> > & block, int m,  int n ) {
    	cout<<"M:"<<m<<"  n:"<<n<<endl;
    	if(m == 9) return true;
    	if(!findIndex(board,m,n)) return true;
    	int i = m;
    	int j = n;
		int t = i / 3 * 3 + j / 3;
		vector<int> valid = common(row[i], col[j], block[t]);
		if(valid.size() == 0) return false;
		
		for(auto k : valid) {
			board[i][j] = k + '0';
			row[i][k - 1] = 0;
			col[j][k - 1] = 0;
			block[t][k - 1] = 0;
			if(find(board, row, col, block, i, j)) return true;
			board[i][j] = '.';
			row[i][k - 1] = k;
			col[j][k - 1] = k;
			block[t][k - 1] = k;
		}

    	return false;
    }

    bool findIndex(vector<vector<char> >& board, int& m, int& n){
    	for(int i = 0; i < 9; i++) {
    		for(int j = 0; j < 9; j++) {
    			if(board[i][j] == '.') {
    				m = i;
    				n = j;
    				return true;
    			}
    		}
    	}
    	return false;
    }
    vector<int> common(vector<int>& row, vector<int>& col, vector<int>& block) {
    	vector<int> result;
    	for(auto i : row) {
    		if( i == 0) continue;
    		for(auto j : col) {
    			if(i != j) continue;
    			for(auto k : block) {
    				if(i != k) continue;
    				result.push_back(i);
    			}
    		}
    	}
    	return result;
    }
};

int main(int argc, char** argv) {
	Solution s;
	vector<vector<char> > row ={
		{'5','3','.','.','7','.','.','.','.'},
		{'6','.','.','1','9','5','.','.','.'},
		{'.','9','8','.','.','.','.','6','.'},
		{'8','.','.','.','6','.','.','.','3'},
		{'4','.','.','8','.','3','.','.','1'},
		{'7','.','.','.','2','.','.','.','6'},
		{'.','6','.','.','.','.','2','8','.'},
		{'.','.','.','4','1','9','.','.','5'},
		{'.','.','.','.','8','.','.','7','9'}};
	s.solveSudoku(row);
	for(auto r : row){
		for(auto t : r) {
			cout<<" "<<t;
		}
		cout<<""<<endl;
	}
}