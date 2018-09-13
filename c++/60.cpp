/**
The set [1,2,3,...,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order, we get the following sequence for n = 3:

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

Note:

Given n will be between 1 and 9 inclusive.
Given k will be between 1 and n! inclusive.
Example 1:

Input: n = 3, k = 3
Output: "213"
Example 2:

Input: n = 4, k = 9
Output: "2314"
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
    string getPermutation(int n, int k) {
        vector<int> v(10, 0);
        vector<int> tag(10, 1);
        for(int i = 1; i <= n; i++) {
            v[i] = 1;
        }
        for(int i = 2; i< 10; i++) {
            tag[i] = i * tag[i - 1];
        }
//        for(int i = 1;i < 10;i++) {
//            cout<< i<<"   ========"<<tag[i]<<endl;
//        }
        return helper(n, k, v, tag);
    }

    string helper(int n , int k, vector<int> & v, vector<int> & tag) {
//        cout<<n<<"   "<<k<<endl;

        if(k == 1){  // find the first num combined by remaining index
           string s = "";
            for(int i =1 ;i < 10; i++) {
                if(v[i] == 1){
                    s.push_back('0' + i);
                }
            }
            return s;
        }

        if(k == tag[n]){
            string s = "";
            for(int i = 9 ;i > 0; i--) {
                if(v[i] == 1){
                    s.push_back('0' + i);
                }
            }
            return s;
        }

        int index = (k - 1) / tag[n - 1] ;
//        cout<<"Index:"<<index<<endl;


        int temp = index + 1 ;
        for(int i = 1;i < 10; i++) {
            if(v[i] == 1) {
                temp --;
                if(temp ==  0) {
                    v[i] = 0;
                    return std::to_string(i).append(helper(n - 1, k - tag[n - 1] * index, v, tag));
                }
            }
        }

        return "";

    }
};


int main(int argc, char** argv) {
	Solution s;
	int n = 9;
	for(int i = 1; i<= 362880;i++) {
	    cout<< i<<" ========  "<<endl<<s.getPermutation(n,i)<<endl;
	}

}