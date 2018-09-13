/**
Given an absolute path for a file (Unix-style), simplify it.

For example,
path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"

Corner Cases:

Did you consider the case where path = "/../"?
In this case, you should return "/".
Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
In this case, you should ignore redundant slashes and return "/home/foo".

"/b/c/" - directory 'b ' - > directory 'c '
"." - current directory
"./" - current directory
"../" - one directory up
e.g
"/" : root directory
"b/c/../" : it will go from c to b
"c/b/./" : it is still in directory b
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
    string simplifyPath(string path) {
        if(path == "/" ||path == "/.") return "/";
        int n = path.size();
        if(n == 0) return "";
        vector<string> stack;

        if(path[0] != '/'){
            path = "/" + path;
        }
        for(int i = 0; i < n;) {
            if(path[i] == '/') {
                int j = i + 1;
                if(j == n) { // push the last '/'
                    stack.push_back("/");
                }
                while(j < n && path[j] != '/') j++;

                if(j == i + 1) { // "//"

                }else {
                    string temp = path.substr(i, j - i);
                    if(temp == "/."){
                    } else if(temp == "/..") {
                        if(stack.size() > 0) {
//                            cout<<"pop===="<<temp<<endl;
                            stack.pop_back();
                        }
                    } else {
//                        cout<<"push==="<<temp<<endl;
                        stack.push_back(temp);
                    }
                }

                i = j;
            }
        }

        if(stack.size() == 0) return "/";
        if (stack[stack.size() - 1] == "/"){
            if(stack.size() > 1){
                stack.pop_back();
            }
        }
        string result = "";
        for(auto s : stack) {
            result += s;
        }

        return result;
    }
};



int main(int argc, char** argv) {
	Solution s;
	cout<< s.simplifyPath("/home/")<< "==="<<"/home"<<endl;
	cout<< s.simplifyPath("/a/./b/../../c/")<< "==="<<"/c"<<endl;
	cout<< s.simplifyPath("/../")<< "==="<<"/"<<endl;
	cout<< s.simplifyPath("/home//foo/")<< "==="<<"/home/foo"<<endl;
	cout<< s.simplifyPath("/.")<< "==="<<"/"<<endl;
	cout<< s.simplifyPath("/c/../.")<< "==="<<"/"<<endl;
	cout<< s.simplifyPath("/..")<< "==="<<"/"<<endl;
	cout<< s.simplifyPath("/a/..")<< "==="<<"/"<<endl;
	}