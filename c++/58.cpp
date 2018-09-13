/**
Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

Example:

Input: "Hello World"
Output: 5
Seen this question in a real interview before?  YesNo
Difficulty:Easy
Total Accepted:200.6K
Total Submissions:625.3K
Contributor:LeetCode
Subscribe to see which companies asked this question.
**/

class Solution {
public:
    int lengthOfLastWord(string s) {
        if(s.size() == 0) return 0;
        int last = 0;
        for(int i = s.size() - 1; i >=0; i--) {
            if(s[i] != ' '){
                last = i;
                break;
            }
        }
        int size = 0;
        for(int i = last; i >=0; i--) {
            if(s[i] == ' ') {
                break;
            }
            size ++;
        }

        return size;
    }
};