/**
Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Example:

Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
Follow up:

If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.

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
    int maxSubArray(vector<int>& nums) {
        int n = nums.size();
        if(n == 0) return 0;

    	int max = nums[0];
    	int maxEnd = nums[0];
    	for(int i = 1; i < n; i++) {
    		int temp  = maxEnd + nums[i];
    		maxEnd = temp > nums[i] ? temp : nums[i];
    		max = max > maxEnd ? max : maxEnd;
    	}
    	return max;
    }
};

int main(int argc, char** argv) {
	Solution s;
	vector<int>  v ={-2,1,-3,4,-1,2,1,-5,4};

	cout<< s.maxSubArray(v)<<endl;
	// for(auto r : result){
	// 	for(auto t : r) {
	// 		cout<<" "<<t <<endl;
	// 	}
	// 	cout<<"==================="<<endl;
	// }
}