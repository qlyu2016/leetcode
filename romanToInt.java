package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;




class Run{
	public static void main(String args[]){
		Solution test = new Solution();

		System.out.println(test.romanToInt("MCMXCVI"));
	}
}

public class Solution {
	private static char[] romans = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
	private static HashMap<String, Integer> nums = new HashMap<String, Integer>();
	
	static{
		nums.put("I", 1);
		nums.put("V", 5);
		nums.put("X", 10);
		nums.put("L", 50);
		nums.put("C", 100);
		nums.put("D", 500);
		nums.put("M", 1000);
	}
	
	public int romanToInt(String s) {
    	int result = 0;
    	
    	char[] chars = s.toCharArray();
    	
    	for(int i = chars.length - 1; i >= 0; i --){
    		if(i == chars.length - 1 && chars[i] == 'I')
    			result += 1;
    		if(i == chars.length - 1 && chars[i] == 'V')
    			result += 5;
    		if(i == chars.length - 1 && chars[i] == 'X')
    			result += 10;
    		if(i == chars.length - 1 && chars[i] == 'L')
    			result += 50;
    		if(i == chars.length - 1 && chars[i] == 'C')
    			result += 100;
    		if(i == chars.length - 1 && chars[i] == 'D')
    			result += 500;
    		if(i == chars.length - 1 && chars[i] == 'M')
    			result += 1000;
    		
    		if((i + 1) <= chars.length - 1 && !positionInorder(chars[i + 1], chars[i])){
    			result += nums.get(String.valueOf(chars[i]));
    		}
    		
    		if((i + 1) <= chars.length - 1 && positionInorder(chars[i + 1], chars[i])){
    			result -= nums.get(String.valueOf(chars[i]));
    		}
    		
    	}
		return result;
    }
	
	public boolean positionInorder(char right, char left){
		int rightP = 0;
		int leftP = 0;
		for(int i = 0; i < this.romans.length; i ++){
			if(right == this.romans[i])
				rightP = i;
			if(left == this.romans[i])
			    leftP = i;
		}
		
		if(rightP > leftP)
			return true;
		else 
			return false;
	}
}