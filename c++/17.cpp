/**
17. Letter Combinations of a Phone Number
DescriptionHintsSubmissionsDiscussSolution
Pick One
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.



Example:

Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Note:

Although the above answer is in lexicographical order, your answer could be in any order you want.
**/

class Solution {
    string letters[10]={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

public:
    vector<string> letterCombinations(string digits) {
        vector<string> v;
        string temp;
        traverse(v,temp,digits,0);
        return v;

    }

    void traverse(vector<string>& v, string& temp, string& digits, int index){
    	int n = digits.size();
    	if(index >= n){
    		return;
    	}
    	int num = digits[index] - '0';
    	int size = letters[num].size();
    	for(int i = 0; i< size; i++) {
    		temp.append(letters[num][i]);
    		if(temp.size() == n){
    			v.push_back(temp);
    		}
    		traverse(v,temp,digits,index + 1);
    		temp = temp.substr(0, temp.size() - 1);
    	}
    }
};