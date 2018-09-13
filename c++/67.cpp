/**
Given two binary strings, return their sum (also a binary string).

The input strings are both non-empty and contains only characters 1 or 0.

Example 1:

Input: a = "11", b = "1"
Output: "100"
Example 2:

Input: a = "1010", b = "1011"
Output: "10101"
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
    string addBinary(string a, string b) {
        int m = a.size();
        int n = b.size();
        if(m == 0) return b;
        if(n ==0 ) return a;

        vector<char> result;
        int tag = 0;
        while(m >0 && n >0){
            int i = a[m - 1] - '0';
            int j = b[n - 1] - '0';

            int sum = i + j + tag;
            tag = sum >= 2 ? 1 : 0;
            int val = sum % 2;
            result.push_back(val + '0');
            m--;
            n--;
        }
        while (m > 0) {
            int i = a[m - 1] - '0';
            int sum = i + tag;
            tag = sum >= 2 ? 1 : 0;
            int val = sum % 2;
            result.push_back(val + '0');
            m--;
        }

         while (n > 0) {
            int i = b[n - 1] - '0';
            int sum = i + tag;
            tag = sum >= 2 ? 1 : 0;
            int val = sum % 2;
            result.push_back(val + '0');
            n--;
        }

        if(tag > 0) result.push_back('1');

        reverse(result.begin(), result.end());
        string str(result.begin(), result.end());
        return str;
    }
};


int main(int argc, char** argv) {
	Solution s;
	cout<< s.addBinary("11","11");
	}