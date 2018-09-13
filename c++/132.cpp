/**
Given a string s, partition s such that every substring of the partition is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.

Example:

Input: "aab"
Output: 1
Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut.
**/

#include <stdio.h>
#include<iostream>
#include <vector>
#include <string>
#include <queue>
#include <map>
using namespace std;


static vector<vector<char> > board =[](){
    std::ios::sync_with_stdio(false);
    cin.tie(NULL);
    return vector<vector<char> >{};
}();

class Solution {

public:
     int minCut(string s) {
     int n = s.size();
     vector<int> tag(n+1, 0);
     for(int i = 0;i <=n;i++){
        tag[i] = i- 1;
     }
        for(int i = 0;i < n;i++){
            for(int j = 0; i -j >= 0&& i+j < n&& s[i-j]==s[i+j];j++){
                tag[i + j + 1] = min(1+ tag[i-j], tag[i + j + 1]);
            }
            for(int j = 1;i-j + 1>=0&& i +j < n&& s[i - j + 1] == s[i + j];j++){
                tag[i + j + 1] = min(1+tag[i -j +1], tag[i + j + 1]);
            }

        }

        return tag[n];
    }


};

int main(int argc, char** argv) {
	Solution s;
    auto re = s.minCut("aababewrtqwrsdfafdaet");
   cout<<re<<endl;
}