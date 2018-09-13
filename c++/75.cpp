/**

Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note: You are not suppose to use the library's sort function for this problem.

Example:

Input: [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
Follow up:

A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
Could you come up with a one-pass algorithm using only constant space?

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
    void sortColors(vector<int>& nums) {
        int first0 = -1;
        int first1 = -1;
        int first2 = -1;
        for(int i = 0;i < nums.size();) {
            if(nums[i] == 0) {
                if(first1 != -1 && first1 < i){
                    swap(nums[i], nums[first1]);
                    first1++;
                }else if( first2 != -1 && first2 < i){
                    swap(nums[i], nums[first2]);
                    first2++;
                    i++;
                }else{
                    i++;
                }
            } else if(nums[i] == 1) {
                 if( first2 != -1 && first2 < i){
                    swap(nums[i], nums[first2]);
                    if(first1 == -1) first1 = first2;
                    first2++;

                }else{
                    if(first1 == -1) first1 = i;
                }
                i++;
            } else{
                if(first2 == -1) first2 = i;
                i++;
            }
        }
    }

};
int main(int argc, char** argv) {
	Solution s;
	vector<int> v ={0,1,2,1,2,1,2,1,1,1,1,1,2,2,2,0,0,0,2};
	s.sortColors(v);
	for(auto a: v) cout<< a<<endl;
	}