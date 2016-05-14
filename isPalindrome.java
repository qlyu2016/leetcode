package leetcode;

import java.util.ArrayList;
import java.util.List;




class Run{
	public static void main(String args[]){
		Solution test = new Solution();

		System.out.println(test.isPalindrome(-2147447412));
	}
}

public class Solution {
    public boolean isPalindrome(int x) {
        
        if(x < 0){
        	return false;
        }
        
        if(x / 10 == 0){
        	return true;
        }
        
        int count = (int) (Math.log10(x)) + 1;
        
        for(int i = 0; i < count / 2; i ++){
        	if((int)(x / Math.pow(10, count - 2 * i - 1)) != x % 10){
        		return false;
        	}
        	x -= (x % 10) * Math.pow(10, count - 2 * i - 1);
        	x /= 10;
        }
        
        return true;
    }
}