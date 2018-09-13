/**

Given a collection of intervals, merge all overlapping intervals.

Example 1:

Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
Example 2:

Input: [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considerred overlapping.
**/

/**
 * Definition for an interval.
 * struct Interval {
 *     int start;
 *     int end;
 *     Interval() : start(0), end(0) {}
 *     Interval(int s, int e) : start(s), end(e) {}
 * };
 */

struct Interval {
      int start;
      int end;
      Interval() : start(0), end(0) {}
      Interval(int s, int e) : start(s), end(e) {}
 };

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
    vector<Interval> merge(vector<Interval>& intervals) {
        sort(intervals.begin(), intervals.end(), [this](Interval i1, Interval i2) {
    	    return i1.start < i2.start;
        });
        vector<Interval> result;
        for(int i = 0; i < intervals.size();) {
            Interval temp = intervals[i];
            int j = i + 1;
            while(j < intervals.size() && intervals[j].start <= temp.end) {
                temp.end = temp.end > intervals[j].end ? temp.end : intervals[j].end;
                j++;
            }
            i = j;
            result.push_back(temp);
        }
        return result;
        
    }

};

int main(int argc, char** argv) {
	Solution s;
	vector<Interval>  v ={{2,3},{1,4}};

	vector<Interval> result =  s.merge(v);
	 for(auto r : result){
        cout<<" "<<r.start<<"  "<<r.end <<endl;
	 	cout<<"==================="<<endl;
	 }
}