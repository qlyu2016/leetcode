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

//Time Limited Out

class Run{
	public static void main(String args[]){
		Solution test = new Solution();
 
		String s = "barfoothefoobarman";
		String[] words = new String[]{"foo", "bar"};
		
		List<Integer> result = test.findSubstring(s, words);
		for(int i = 0; i < result.size(); i ++){
			System.out.print(result.get(i) + " ");
		}
		
	}
}

public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if(s.length() < 1 || words.length < 1){
        	return result;
        }
        
    	HashMap<String, Integer> map = new HashMap<>();
    	int len = words[0].length();
    	
    	for(int i = 0; i < words.length; i ++){
    		if(map.containsKey(words[i]))
    		    map.put(words[i], map.get(words[i]) + 1);
    		else
    			map.put(words[i], 1);
    	}
    	
    	for(int i = 0; i <= s.length() - len * words.length; i ++){
    		HashMap<String, Integer> temp = (HashMap<String, Integer>) map.clone();
    		int from = i;
    		String str = s.substring(from, from + len);
    		while(temp.containsKey(str)){
    			if(temp.get(str) == 1)
    				temp.remove(str);
    			else
    				temp.replace(str, temp.get(str) - 1);
    			from += len;
    			if(from + len > s.length())
    				break;
    			str = s.substring(from, from + len);
    		}
    		
    		if(temp.isEmpty()){
    			result.add(i);
    		}
    	}
    	
    	return result;
    }
}