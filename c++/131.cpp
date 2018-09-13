/**
Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

Example:

Input: "aab"
Output:
[
  ["aa","b"],
  ["a","a","b"]
]
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
    vector<vector<string>> partition(string s) {
         vector<vector<string>> result;
         vector<string> temp;
         find(result, temp, 0, s.size() - 1, s);
         return result;
    }

    void find(vector<vector<string>> &result, vector<string>& temp, int start, int end, string& s){
        if(start > end){
            vector<string> find = temp;
            result.push_back(find);
            return;
        }

        for(int i = start; i<=end;i++){
            if(isPalindrome(s, start, i)){
                temp.push_back(s.substr(start, i - start + 1));
                find(result, temp, i + 1, end, s);
                temp.pop_back();
            }
        }
    }
    bool isPalindrome(string & s, int start, int end){
        if(start == end) return true;

        while(start<=end) {
            if(s[start] == s[end]){
                start++;
                end--;
            } else {
                return false;
            }
        }

        return true;
    }
};

int main(int argc, char** argv) {
	Solution s;
    auto re = s.partition("aab");
    for(auto v : re){
        for( auto sub : v){
            cout<< sub<<" ";
        }
        cout<<endl;
    }
}