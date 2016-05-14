package leetcode;

import java.util.ArrayList;
import java.util.List;




class Run{
	public static void main(String args[]){
		Solution test = new Solution();

		System.out.println(test.myAtoi("9223372036854775809"));
	}
}

public class Solution {
    public int myAtoi(String str) {
        if(str.equals(""))
        	return 0;
        
    	char[] input = str.toCharArray();
        long x = 0;
        
        int check = 0;
        while(input[check] == ' '){
        	check ++;
        }
        
        if(check < str.length() && input[check] == '+'){
        	check ++;
            while(check < str.length() && input[check] >= '0' && input[check] <= '9'){
            	x = x * 10 + (input[check] - 48);
            	check ++;
                if(x > Integer.MAX_VALUE){
                	return Integer.MAX_VALUE;
                }
            }
            return (int)x;
            
        }else if(check < str.length() && input[check] == '-'){
        	check ++;
            while(check < str.length() && input[check] >= '0' && input[check] <= '9'){
            	x = x * 10 + (input[check] - 48);
            	check ++;
            	if(-x < Integer.MIN_VALUE){
            	   return Integer.MIN_VALUE;
                }
            }
            return (int)-x;

        }else{
            while(check < str.length() && input[check] >= '0' && input[check] <= '9'){
            	x = x * 10 + (input[check] - 48);
            	check ++;
            	if(x > Integer.MAX_VALUE){
            	   return Integer.MAX_VALUE;
                }
            }
            return (int)x;

        }
    }
}