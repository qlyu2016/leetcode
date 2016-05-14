package leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;




class Run{
	public static void main(String args[]){
		Solution test = new Solution();

		String[] strs = {
				"aa",
				"a"
		};
        System.out.println(test.longestCommonPrefix(strs));
	}
}



public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0)
        	return "";
        if(strs.length == 1)
        	return strs[0];
        
    	boolean check = true;
        int count = 0;
        
    	while(check){
    		if(strs[0].length() <= count){
    			check = false;
    			break;
    		}
    		char temp = strs[0].charAt(count);
        	for(int i = 1; i < strs.length; i ++){
        		if(strs[i].length() <= count){
        			check = false;
        			break;
        		}
        		if(strs[i].charAt(count) != temp){
        			check = false;
        			break;
        		}
        	}
        	if(check)
        	   count ++;
        }
    	
    	if(count > 0){
    	    return strs[0].substring(0, count);
    	}else{
    		return "";
    	}
    }
}