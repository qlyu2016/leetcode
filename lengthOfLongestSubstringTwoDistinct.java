package leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Stack;
import java.util.Queue;
import java.util.TreeSet;


class Run{
	public static void main(String args[]){
		Solution test = new Solution();

        String s = "cdaba";
        System.out.println(test.lengthOfLongestSubstringTwoDistinct(s));
        
	}
}

public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        HashMap<String, Integer> map = new HashMap<>();
        if(s.length() <= 2){
        	return s.length();
        }
        
        int left = 0;
        int right = 1;
        map.put(String.valueOf(s.charAt(left)), 1);
        if(map.get(String.valueOf(s.charAt(right))) != null){
        	map.put(String.valueOf(s.charAt(right)), 2);
        }else{
        	map.put(String.valueOf(s.charAt(right)), 1);
        }
        
        int result = 2;
        while(map.size() > 2 || s.length() - 1 > right){
        	if(right < s.length() - 1){
        		right ++;
        	}
        	
        	if(map.get(String.valueOf(s.charAt(right))) != null){
            	map.put(String.valueOf(s.charAt(right)), map.get(String.valueOf(s.charAt(right))) + 1);
            }else{
            	map.put(String.valueOf(s.charAt(right)), 1);
            }
        	
        	if(map.size() > 2){
        		while(map.size() > 2){
        			if(map.get(String.valueOf(s.charAt(left))) > 1){
                    	map.put(String.valueOf(s.charAt(left)), map.get(String.valueOf(s.charAt(left))) - 1);
                    }else{
                    	map.remove(String.valueOf(s.charAt(left)));
                    }
        			left ++;
        		}
        	}
        	
        	if(map.size() <= 2 && right - left + 1 > result){
        		result = right - left + 1;
        	}
        }
        
        return result;
    }
}