/**
Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.

Example 1:

Input: num1 = "2", num2 = "3"
Output: "6"
Example 2:

Input: num1 = "123", num2 = "456"
Output: "56088"
Note:

The length of both num1 and num2 is < 110.
Both num1 and num2 contain only digits 0-9.
Both num1 and num2 do not contain any leading zero, except the number 0 itself.
You must not use any built-in BigInteger library or convert the inputs to integer directly.
**/

#include <stdio.h>
#include<iostream>
#include <vector>
#include <string> 
using namespace std;

class Solution {
public:
    string multiply(string num1, string num2) {
        string result(num1.size() + num2.size(),'0');

        for(int i = num1.size() - 1; i>=0; i--) {
        	for(int j = num2.size() - 1; j>=0; j--) {
		   		int index = i + j;
        		int temp = (num1[i] - '0') * (num2[j] - '0') + (result[index + 1] - '0');
        		result[index] = result[index] + temp / 10;
        		result[index + 1] = (temp % 10 + '0');
        	}
        }

        auto first = result.find_first_not_of('0');
        if(first != string::npos) {
        	return result.substr(first);
        } 
        return "0";
    }


};

int main(int argc, char** argv) {
	Solution s;
	cout<<s.multiply("123", "456")<<endl;
}