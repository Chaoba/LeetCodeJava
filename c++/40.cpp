/**
Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

Each number in candidates may only be used once in the combination.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8,
A solution set is:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
Example 2:

Input: candidates = [2,5,2,1,2], target = 5,
A solution set is:
[
  [1,2,2],
  [5]
]
[[1,1,6],[1,1,1,5],[1,1,5,1],[1,2,2,1,1,1],[1,2,5],[1,7],[1,6,1],[1,1,6],[1,1,1,5],[1,1,5,1],[1,5,2],[1,5,1,1],[2,1,2,1,1,1],[2,1,5],[2,2,2,1,1],[2,2,1,1,1,1],[2,6],[2,1,2,1,1,1],[2,1,5],[2,5,1],[7,1],[7,1],[6,1,1],[6,2],[6,1,1],[1,1,6],[1,1,1,5],[1,1,5,1],[1,2,2,1,1,1],[1,2,5],[1,7],[1,6,1],[1,1,6],[1,1,1,5],[1,1,5,1],[1,5,2],[1,5,1,1],[5,1,2],[5,1,1,1],[5,2,1],[5,1,2],[5,1,1,1]]

**/
#include <stdio.h>
#include<iostream>
#include <vector>
#include <set>
using namespace std;

class Solution {
public:
    vector<vector<int> > combinationSum2(vector<int>& candidates, int target) {
        vector<vector<int> > result;
        vector<int> temp;
        sort(candidates.begin(), candidates.end());
        find(result, temp, candidates, 0, target);
        return result;
    }

    void find(vector<vector<int> >& result,vector<int>& temp, vector<int>& candidates, int index, int target) {
    	if(target == 0) {
    		std::vector<int> v = temp;
    		result.push_back(v);
    		return;
    	}

    	for(int i = index; i< candidates.size(); i++) {
    		if(candidates[i] > target) continue;
    		if(i > index && candidates[i] == candidates[i - 1]) continue;
    		temp.push_back(candidates[i]);
    		find(result, temp, candidates, i + 1, target - candidates[i]);
    		temp.pop_back();
    	}
    }
};

int main(int argc, char** argv) {
	int source[]={1,1,2,5,6,7};
	std::vector<int> s;
  	s.insert(s.begin(), source, source+sizeof(source)/sizeof(source[0]));

	Solution solution;
	vector<vector<int> >  result = solution.combinationSum2(s,8);
	for(auto i : result){
		for (auto j: i) {
			cout<<" "<<j;
		}
		cout<<""<<endl;
	}
}