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
import java.util.Set;
import java.util.Stack;
import java.util.Queue;
import java.util.TreeSet;


class Run{
	public static void main(String args[]){
		Solution test = new Solution();

		
	}
}

public class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
    	if(word1.equals(word2)){
    		List<Integer> pos = new ArrayList<>();
    		int result = Integer.MAX_VALUE;
    		
    		for(int i = 0; i < words.length; i ++){
    			if(words[i].equals(word1)){
    				pos.add(i);
    			}
    		}
    		
    		for(int i = 0; i < pos.size() - 1; i ++){
    			if(Math.abs(pos.get(i) - pos.get(i + 1)) < result){
    				result = Math.abs(pos.get(i) - pos.get(i + 1));
    			}
    		}
    		
    		return result;
    	}
    	
    	List<Integer> pos1 = new ArrayList<>();
        List<Integer> pos2 = new ArrayList<>();
        int result = Integer.MAX_VALUE;
        
        for(int i = 0; i < words.length; i ++){
        	if(words[i].equals(word1)){
        		pos1.add(i);
        	}
        	if(words[i].equals(word2)){
        		pos2.add(i);
        	}
        }
        
        for(int i = 0; i < pos1.size(); i ++){
        	for(int j = 0; j < pos2.size(); j ++){
        		if(Math.abs(pos1.get(i) - pos2.get(j)) < result){
        			result = Math.abs(pos1.get(i) - pos2.get(j));
        		}
        	}
        }
        
        return result;
    }
}