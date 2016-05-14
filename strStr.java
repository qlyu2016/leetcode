package leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;




class Run{
	public static void main(String args[]){
		Solution test = new Solution();
        
		String haystack = "iieglhroaeot";
		String needle = "glhr";
		
        System.out.println(test.strStr(haystack, needle));

	}
}

public class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack.length() == 0 && needle.length() == 0)
        	return 0;
        if(haystack.length() == 0 && needle.length() != 0)
        	return -1;
        if(needle.length() == 0)
        	return 0;
    	
    	for(int i = 0; i < haystack.length() - needle.length() + 1; i ++){
        	if(haystack.charAt(i) == needle.charAt(0)){
        		int j = 0;
        		for( ; j < needle.length(); j ++){
        			if((i + j) >= haystack.length() || haystack.charAt(i + j) != needle.charAt(j)){
        				break;
        			}
        		}
        		if(j == needle.length())
        			return i;
        	}
        }
    	
    	return -1;
    }
}