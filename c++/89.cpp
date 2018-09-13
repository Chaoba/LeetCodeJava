/**
The gray code is a binary numeral system where two successive values differ in only one bit.

Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.

Example 1:

Input: 2
Output: [0,1,3,2]
Explanation:
00 - 0
01 - 1
11 - 3
10 - 2

For a given n, a gray code sequence may not be uniquely defined.
For example, [0,2,3,1] is also a valid gray code sequence.

00 - 0
10 - 2
11 - 3
01 - 1
Example 2:

Input: 0
Output: [0]
Explanation: We define the gray code sequence to begin with 0.
             A gray code sequence of n has size = 2n, which for n = 0 the size is 20 = 1.
             Therefore, for n = 0 the gray code sequence is [0].

             0,1,3,2,6,7,5,4,12,13,15,14,10,11,9,8,24,25,27,26,30,31,29,28,20,21,23,22,18,19,17,16
               1,2-1,4,1-2-1,8,  1  2 -1 -4 1  -2 -1
             **/

class Solution {
public:
    vector<int> grayCode(int n) {
        vector<int> result(1<<n);
        int index = 1;
        for(int m = 0; m < n; m ++){
            int sufi = 1 << m;
            for(int i = index ; i >=0; i--){
                result[index ++] = sufi + result[i];
            }
        }
        return result;
    }

};