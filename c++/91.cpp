/**
A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given a non-empty string containing only digits, determine the total number of ways to decode it.

Example 1:

Input: "12"
Output: 2
Explanation: It could be decoded as "AB" (1 2) or "L" (12).
Example 2:

Input: "226"
Output: 3
Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
**/
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
    int numDecodings(string s) {
        if(s.size() == 0) return 1;
        if(s[0] =='0') {
                return 0;
            }
        if(s.size() == 1){
             return 1;
        }
        int m = 0;
        m = s.size();
        vector<int> tag(m + 1, 0);
        tag[0] = 1;
        tag[1] = s[0] == '0' ? 0 : 1;

        for(int i = 2; i <= m ; i++){
            int first = atoi(s.substr(i - 1, 1).c_str());
            int second = atoi(s.substr(i - 2, 2).c_str());
            if(first > 0 && first < 10){
                tag[i] += tag[i - 1];
            }
            if(second < 27 && second > 9){
                tag[i] += tag[i - 2];
            }

        }


        return tag[m];
    }
};

int main() {
	Solution s;
	cout<<s.numDecodings("12")<<endl;
	cout<<s.numDecodings("226")<<endl;
	cout<<s.numDecodings("2")<<endl;
	cout<<s.numDecodings("2111")<<endl;
	cout<<s.numDecodings("111")<<endl;
	cout<<s.numDecodings("10")<<endl;
	cout<<s.numDecodings("101")<<endl;
	cout<<s.numDecodings("3010")<<endl;
	cout<<s.numDecodings("110")<<endl;
}