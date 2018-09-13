/**
Validate if a given string is numeric.

Some examples:
"0" => true
" 0.1 " => true
"abc" => false
"1 a" => false
"2e10" => true

Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one.

Update (2015-02-10):
The signature of the C++ function had been updated. If you still see your function signature accepts a const char * argument, please click the reload button to reset your code definition.
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
    bool isNumber(string s) {
        s.erase(0,s.find_first_not_of(" "));
        s.erase(s.find_last_not_of(" ") + 1);
        int n = s.size();
        if( n == 0) return false;
        if(s[0] == '-' || s[0] == '+') {
            s = s.substr(1);
            n--;
        }

        return helper(s, 0, n, false);
    }

    bool helper(string& s, int index, int n, int only_num) {
        for(int i = index; i < n; i++){
            if(s[i] >= '0' && s[i] <= '9') continue;
            else if(only_num) {
                return false;
            }

            if(s[i] == 'e'){
                return i > 0 && i != s.size() - 1 && helper(s, i + 1, n, true);
            } else if(s[i] == '.'){
                return s.size() == 1 ? false : helper(s, i + 1, n, true);
            } else {
                return false;
            }
        }
        return true;
    }
};


int main(int argc, char** argv) {
	Solution s;

	cout<<"1=="<< s.isNumber("0")<<"  "<<1<<endl;
	cout<<"2=="<< s.isNumber(" 0.1 ")<<"  "<<1<<endl;
	cout<<"3=="<< s.isNumber("abc")<<"  "<<0<<endl;
	cout<<"4=="<<s.isNumber("1 a")<<"  "<<0<<endl;
	cout<<"5=="<< s.isNumber("2e10")<<"  "<<1<<endl;
	cout<<"6=="<< s.isNumber(".")<<"  "<<0<<endl;
	cout<<"8=="<< s.isNumber("e12")<<"  "<<0<<endl;
	cout<<"9=="<<s.isNumber("1e")<<"  "<<0<<endl;
	cout<<"10=="<< s.isNumber("1.")<<"  "<<1<<endl;
	cout<<"11=="<<s.isNumber(".1")<<"  "<<1<<endl;
	cout<<"12=="<< s.isNumber("1.0")<<"  "<<1<<endl;
	cout<<"13=="<< s.isNumber("01")<<"  "<<1<<endl;

	}