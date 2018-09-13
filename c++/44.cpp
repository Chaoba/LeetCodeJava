
/**
Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*'.

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).
The matching should cover the entire input string (not partial).

Note:

s could be empty and contains only lowercase letters a-z.
p could be empty and contains only lowercase letters a-z, and characters like ? or *.
Example 1:

Input:
s = "aa"
p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".
Example 2: 

Input:
s = "aa"
p = "*"
Output: true
Explanation: '*' matches any sequence.
Example 3:

Input:
s = "cb"
p = "?a"
Output: false
Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.
Example 4:

Input:
s = "adceb"
p = "*a*b"
Output: true
Explanation: The first '*' matches the empty sequence, while the second '*' matches the substring "dce".
Example 5:

Input:
s = "acdcb"
p = "a*c?b"
Output: false

**/
#include <stdio.h>
#include<iostream>
#include <vector>
#include <string> 
using namespace std;


class Solution {
public:
    bool isMatch(string s, string p) {
    	int m = s.size();
    	int n = p.size() ;
    	int tagI= -1;
    	int tagJ = -1;
    	int i = 0;
    	int j = 0;
    	while(i < m){
    		cout<<"i::"<<i<<"  j:"<<j<<" tagI:"<<tagI<<endl;
    		if(s[i] == p[j] || p[j] == '?'){
    			i ++;
    			j ++;
    			continue;
    		}

    		if(p[j] == '*') {
    			tagI = i;
    			tagJ = ++j;
    			continue;
    		}

    		if( tagJ >=0) {
    			j = tagJ;
    			i = ++tagI;
    			continue;
    		}

    		return false;
    	}

    	while(j < n && p[j] == '*') j++;

    	return j == n;
    }
};

int main(int argc, char** argv) {
	Solution s;
	s.isMatch("aabbc","a*b");
	// cout<<"should be:"<<1<<"==="<<s.isMatch("aa","a?")<<endl;
	// cout<<"should be:"<<0<<"==="<<s.isMatch("acdcb","a*c?b")<<endl;
	// cout<<"should be:"<<0<<"==="<<s.isMatch("aa","a")<<endl;
	// cout<<"should be:"<<1<<"==="<<s.isMatch("aa","a*")<<endl;
	// cout<<"should be:"<<1<<"==="<<s.isMatch("aa","*a")<<endl;
	// cout<<"should be:"<<1<<"==="<<s.isMatch("aa","?a")<<endl;
	// cout<<"should be:"<<1<<"==="<<s.isMatch("aa","*")<<endl;
	// cout<<"should be:"<<0<<"==="<<s.isMatch("aa","")<<endl;
	// cout<<"should be:"<<1<<"==="<<s.isMatch("","*")<<endl;
	// cout<<"should be:"<<0<<"==="<<s.isMatch("","?")<<endl;
	// cout<<"should be:"<<1<<"==="<<s.isMatch("","")<<endl;
	// cout<<"should be:"<<1<<"==="<<s.isMatch("aabb","a*b")<<endl;
	// cout<<"should be:"<<1<<"==="<<s.isMatch("aabb","*")<<endl;
	// cout<<"should be:"<<0<<"==="<<s.isMatch("aab","c*a*b")<<endl;
	// cout<<"should be:"<<1<<"==="<<s.isMatch("aabbbcc","a*b*")<<endl;
	// cout<<"should be:"<<1<<"==="<<s.isMatch("abefcdgiescdfimde","ab*cd?i*de")<<endl;


}
