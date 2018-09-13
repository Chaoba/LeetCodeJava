34.cpp
/**
Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
**/

class Solution {
public:
    vector<int> searchRange(vector<int>& nums, int target) {
    	vector<int> result;

        result.push_back(helper(nums, target, 1));
        result.push_back(helper(nums, target, 0));

        return result;
    }

    int helper(std::vector<int>& nums, int target, int find_begin){
    	int i = 0; 
    	int j = nums.size() - 1;
    	while(i <= j){
    		int mid = i + (j - i)/2;
    		if(nums[mid] == target) {
    			if(find_begin) {
    				j = mid - 1;
    			} else{
    				i = mid + 1;
    			}
    		}else if(nums[mid] > target) {
    			j = mid - 1;
    		} else {
    			i = mid + 1;
    		}
    	}

    	if(find_begin) {
    		return (i < nums.size() && nums[i] == target)? i : -1;
    	} else{
    		return (j >=0 && nums[j] == target)? j : -1;
    	}
    }
};