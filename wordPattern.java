package leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


class Run{
	public static void main(String args[]){
		Solution test = new Solution();

		String pattern = "abba";
		String str = "dog cat cat dog";
		
		System.out.print(test.wordPattern(pattern, str));
		
	}
}

public class Solution {
	private HashMap<String, String> cor = new HashMap<>();
	private HashMap<String, String> correv = new HashMap<>();
	
    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        if(words.length != pattern.length()){
        	return false;
        }
        
        for(int i = 0; i < pattern.length(); i ++){
        	String tempKey = String.valueOf(pattern.charAt(i));
        	String tempValue = words[i];
        	if(cor.get(tempKey) == null){
        		if(correv.get(tempValue) == null){
        			cor.put(tempKey, tempValue);
        			correv.put(tempValue, tempKey);
        		}else{
        			return false;
        		}
        		
        	}else{
        		if(correv.get(tempValue) == null){
        			return false;
        		}else{
        			if(!cor.get(tempKey).equals(tempValue) || !correv.get(tempValue).equals(tempKey))
        				return false;
        		}
        	}
        }
        
        return true;
    }
}