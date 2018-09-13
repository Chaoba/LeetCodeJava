/**
Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

Example 1:

Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
Output: true
Example 2:

Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
Output: false
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


    bool isInterleave(string s1, string s2, string s3) {
        int m = s1.size();
        int n = s2.size();
        int t = s3.size();
        if(m + n != t) return false;
        vector<vector<int> > v(m + 1, vector<int>(n + 1, 0));
        v[0][0] = 1;
        for(int i = 1; i < m + 1;i++) {
            if(s1[i - 1] == s3[i - 1]){
                v[i][0] = 1;
            } else{
                break;
            }
        }

        for(int i = 1; i < n + 1; i++) {
             if(s2[i - 1] == s3[i - 1]){
                 v[0][i] = 1;
             } else {
                break;
             }
        }
        for(int i = 1; i <= m; i++ ){
            for(int j = 1; j<=n; j++) {
                if(v[i - 1][j] == 1 && s1[i - 1] == s3[i + j - 1]){
                    v[i][j] = 1;
                }

                if(v[i][j -1] == 1 && s2[j - 1] == s3[i + j - 1]){
                    v[i][j] = 1;
                }


            }
        }

        return v[m][n] == 1;
    }
//    bool isInterleave(string s1, string s2, string s3) {
//        cout<<s1.size()<<"===="<<s2.size()<<"========"<<s3.size()<<endl;
//        if(s1.size() + s2.size() != s3.size()) return false;
//        if(s3.size() == 0) return true;
//        if(s1.size() == 0){
//            for(int i = 0; i< s3.size();i++) {
//                if(s2[i] != s3[i]) return false;
//            }
//            return true;
//        }
//
//        if(s2.size() == 0){
//            for(int i = 0; i< s3.size();i++) {
//                if(s1[i] != s3[i]) return false;
//            }
//            return true;
//        }
//        string s1new = s1.substr(1);
//        string s2new = s2.substr(1);
//        string s3new = s3.substr(1);
//        if(s3[0] == s1[0] && s3[0] == s2[0]){
//           return isInterleave(s1new, s2, s3new) || isInterleave(s1, s2new, s3new);
//        } else if(s3[0] == s1[0]) {
//            return isInterleave(s1new, s2, s3new);
//        } else if(s3[0] == s2[0]) {
//            return isInterleave(s1, s2new, s3new);
//        }
//
//        return false;
//    }
};


int main() {
	Solution s;
	cout<<1<<"======"<<s.isInterleave("aa",  "ab", "aaba")<<endl;
	cout<<1<<"======"<<s.isInterleave("aabcc",  "dbbca", "aadbbcbcac")<<endl;
	cout<<0<<"======"<<s.isInterleave("aabcc",  "dbbca", "aadbbbaccc")<<endl;
	cout<<0<<"======"<<s.isInterleave("1",  "1", "1")<<endl;
	cout<<1<<"======"<<s.isInterleave("1",  "1", "11")<<endl;
	cout<<1<<"======"<<s.isInterleave("",  "11", "11")<<endl;
	cout<<1<<"======"<<s.isInterleave("bbbbbabb",  "babaaaa", "babbbabbbaaabba")<<endl;
	cout<<0<<"======"<<s.isInterleave("bbbbbabbbbabaababaaaabbababbaaabbabbaaabaaaaababbbababbbbbabbbbababbabaabababbbaabababababbbaaababaa",
"babaaaabbababbbabbbbaabaabbaabbbbaabaaabaababaaaabaaabbaaabaaaabaabaabbbbbbbbbbbabaaabbababbabbabaab",
"babbbabbbaaabbababbbbababaabbabaabaaabbbbabbbaaabbbaaaaabbbbaabbaaabababbaaaaaabababbababaababbababbbababbbbaaaabaabbabbaaaaabbabbaaaabbbaabaaabaababaababbaaabbbbbabbbbaabbabaabbbbabaaabbababbabbabbab")<<endl;
}