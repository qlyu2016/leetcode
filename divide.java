package leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


class Run{
	public static void main(String args[]){
		Solution test = new Solution();

		int dividend = -2147483648;
		int divisor =  -1;
        System.out.println(test.divide(dividend, divisor));
	}
}

public class Solution {
    public int divide(int dividend, int divisor) {
        if(divisor == 0)
        	return Integer.MAX_VALUE;
        
        long res = 0;
        if(dividend == Integer.MIN_VALUE)
        {
            res = 1;
            dividend += Math.abs(divisor);
        }
        
        if(divisor == Integer.MIN_VALUE)
            return (int)res;
        
        boolean isNeg = ((dividend ^ divisor) >>> 31 == 1) ? true : false;
        long dividends = Math.abs(dividend);
        long divisors = Math.abs(divisor);
    	
        int digit = 0;
        while(divisors <= (dividends >> 1))
        {
            divisors <<= 1;
            digit ++;
        }
        
        while(digit >= 0)
        {
            if(dividends >= divisors)
            {
                dividends -= divisors;
                res += 1 << digit;
            }
            divisors >>= 1;
            digit --;
        }
        
        if(isNeg){
        	if(res <= Integer.MIN_VALUE)
        		return Integer.MAX_VALUE;
        	else
        		return (int)-res;
        }else{
        	if(res >= Integer.MAX_VALUE)
        		return Integer.MAX_VALUE;
        	else
        	    return (int)res;
        }
        
    	
    }
}