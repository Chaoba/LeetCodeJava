/**
Implement int sqrt(int x).

Compute and return the square root of x, where x is guaranteed to be a non-negative integer.

Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.

Example 1:

Input: 4
Output: 2
Example 2:

Input: 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since
             the decimal part is truncated, 2 is returned.
             **/

class Solution {
public:
    int mySqrt(int x) {
        int i = 0;
        int j = 14654;
        int result = 0;
        while(i <= j) {
            int mid = (i + j) / 2;
            int multi = mid * mid;
            if(multi == x){
                return mid;
            } else if(multi < x) {
                result =  result > mid ? result: mid;
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }

        return result;
    }

    int mySqrt(int x) {
      if(x==1) return 1;
      unsigned long long X=x, sqrtX=X/2;
      while(!(((sqrtX*sqrtX)<=X && ((sqrtX+1)*(sqrtX+1))>X)))
        sqrtX = 0.5*(sqrtX + X/sqrtX);
      return sqrtX;
    }
};