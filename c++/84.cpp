/**
Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.


Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].




The largest rectangle is shown in the shaded area, which has area = 10 unit.



Example:

Input: [2,1,5,6,2,3]
Output: 10

*/
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
    int largestRectangleArea(vector<int>& heights) {

        int ret = 0;
        heights.push_back(0);
        stack<int> s;

        int i = 0;
        while(i < heights.size()){
            if(s.empty() || heights[i] > heights[s.top()]){
                s.push(i++);
            } else {
                int j = s.top();
                s.pop();
                int h = heights[j];
                int w = s.empty() ? i : (i - s.top() - 1);
                cout<<"h:"<<h<<"  w:"<<w<<endl;
                int rect = h * w;
                ret = ret < rect ? rect : ret;

            }
        }

        return ret;
    }


};

int main(int argc, char** argv) {
	Solution s;
	vector<int> v ={4,2,0,3,2,5};
	cout<< s.largestRectangleArea(v);
	}