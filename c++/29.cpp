29.cpp

class Solution {
public:
   int divide(int dividend, int divisor) {
      
        if(dividend == INT_MIN){
            if(divisor == -1) return INT_MAX;
            if(divisor == 1) return INT_MIN;
        }
        long m = (long)abs(dividend);
        long n = (long)abs(divisor);
        if(m < n) return 0;
        int r = 0;
        long temp = n;
        int multi = 1;
        while(m - temp > 0) {
            temp = temp << 1;
            multi = multi << 1;
        }
        
        // find the max value that lower than m 
        if(temp != n){
            temp = temp >> 1;
            multi = multi >> 1;
        }
        r = multi + divide_max(m - temp , n, temp, multi);

        if((dividend < 0 && divisor >0) || (dividend > 0 && divisor < 0)){
            r = -r;
        }
        return r;
    }

    int divide_max(long m , long n, long max_val, int multi) {
    	if(m < n) return 0;
        if(m == n) return 1;
        while(m - max_val < 0){
            max_val = max_val >> 1;
            multi = multi >> 1;
        }

        return multi + divide_max(m - max_val , n, max_val, multi);
    }
};