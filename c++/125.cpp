/**
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Note: For the purpose of this problem, we define empty string as valid palindrome.

Example 1:

Input: "A man, a plan, a canal: Panama"
Output: true
Example 2:

Input: "race a car"
Output: false

**/

class Solution {
public:
    bool isPalindrome(string s) {
        int i = 0;
        int j = s.size() - 1;
        while(i < j){
            while(i < s.size() && !isChar(s[i])) i++;
            while(0 <= j && !isChar(s[j])) j--;
            if(j <= i) return true;
            if(getV(s[i]) == getV(s[j])){
                i++;
                j--;
            }else{
                return false;
            }
        }
        return true;
    }

    bool isChar(char c){
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9');
    }

    int getV(char c){
        if((c >= 'a' && c <= 'z')) return c - 'a';
        else if(c >= 'A' && c <= 'Z') return c - 'A';
        else return c - '0' + 100;
    }
};