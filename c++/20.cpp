20.cpp
/**

Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Note that an empty string is also considered valid.

Example 1:

Input: "()"
Output: true
Example 2:

Input: "()[]{}"
Output: true
Example 3:

Input: "(]"
Output: false
Example 4:

Input: "([)]"
Output: false
Example 5:

Input: "{[]}"
Output: true
**/
class Solution {
public:
    bool isValid(string s) {
    	int size = s.size();
    	if(size == 0) return true;
        std::vector<char> v;
        for(int i = 0; i < size; i++){
        	if(s[i] == '(' || s[i] == '[' || s[i] == '{'){
        		v.push_back(s[i]);
        	} else if(s[i] == ')' || s[i] == ']' || s[i] == '}'){
        		if(v[v.size() -1] != s[i]) return false;
        		v.pop_back();
        	}
        }
        return true;
    }
};