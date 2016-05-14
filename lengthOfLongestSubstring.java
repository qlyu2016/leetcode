package leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Stack;
import java.util.Queue;


class Run{
	public static void main(String args[]){
		Solution test = new Solution();

		String s = "tmmzuxt";
		System.out.println(test.lengthOfLongestSubstring(s));
	}
}

public class Solution {
	private HashMap<String, Integer> record = new HashMap<>();
	
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        if(s.length() == 0)
        	return result;
        
        int start = 0;
        int end = 0;
        
    	while(end <= s.length() - 1){
    		String now = String.valueOf(s.charAt(end));
    		
    		if(record.get(now) == null){
    			record.put(now, end);
    			int temp = end - start + 1;
    			if(temp > result){
    				result = temp;
    			}
    			end ++;
    		}else{
    			int temp = end - start;
    			if(temp > result){
    				result = temp;
    			}
    			int newstart = record.get(now) + 1;
    			for(int i = start; i < newstart; i ++){
    				record.remove(String.valueOf(s.charAt(i)));
    			}
    			start = newstart;
    			record.put(now, end);
    			end ++;
    		}
    	}
    	return result;
    }
}