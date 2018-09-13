22.cpp
/**
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
**/
class Solution {
public:
	 vector<string> generateParenthesis(int n) {
        std::vector<string> result;

      	int start = (int)pow(2.0, n);
      	int end = (int)pow(2.0, n * 2);
      	for (int i = start; i < end; i++){
      		if(isValid(n, i)){
      			string s = "";
                int temp = i;
	      		while(temp > 0){
	      			if(temp & 1 == 1) {
	      				s = "(" + s;
	      			} else {
	      				s = ")" + s;
	      			}
                   temp = temp >> 1;
	      		}
	      		result.push_back(s);
      		}
      	}
      	
        return result;
    }

    bool isValid(int n, int num){
    	int one = 0;
    	int zero = 0;
    	while(num > 0){
    		if(num & 1 == 1){
    			one ++;
    		} else {
    			zero ++;
    		}
    		if(one > zero) return false;
    		num = num >> 1;
    	}

    	return one == n && zero == n;
    }
};