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

//        char[][] board = {
//        		  {'A','B','C','E'},
//        		  {'S','F','C','S'},
//        		  {'A','D','E','E'}
//        };
//        String word = "ABCCED";
//		System.out.println(test.exist(board, word));
        
		String s = "a";
		
		List<String> result = test.generatePalindromes(s);
		for(int i = 0; i < result.size(); i ++){
			System.out.println(result.get(i));
		}
		
	}
}

public class Solution {
	private List<String> result = new ArrayList<>();
	
    public List<String> generatePalindromes(String s) {
        HashMap<String, Integer> record = new HashMap<>();
        char[] c = s.toCharArray();
        
        for(int i = 0; i < s.length(); i ++){
        	String temp = String.valueOf(c[i]);
        	
        	if(record.get(temp) == null){
        		record.put(temp, 1);
        	}else{
        		record.put(temp, record.get(temp) + 1);
        	}
        }
        int count = 0;
        String odd = "";
        List<String> remain = new ArrayList<>();
        
        for(String k : record.keySet()){
        	int temp = record.get(k);
        	if(temp % 2 == 1){
        		if(count == 0){
        		   count ++;
        		   odd = odd.concat(k);
        		   for(int i = 0; i < temp / 2; i ++){
        		     remain.add(k);
        		   }
        		}else{
        			return this.result;
        		}
        	}else{
        		for(int i = 0; i < temp / 2; i ++){
        			remain.add(k);
        		}
        	}
        }
        
        permute(new ArrayList<>(), remain, odd);
        
        return this.result;
    }
    
    public void permute(List<String> list, List<String> remain, String odd){
    	if(remain.size() == 0){
    		StringBuffer left = new StringBuffer("");
    		StringBuffer right = new StringBuffer("");
    		for(int i = 0; i < list.size(); i ++){
    			left.append(list.get(i));
    			right.append(list.get(list.size() - 1 - i));
    		}
    		left.append(odd);
    		left.append(right);
    		
    		this.result.add(left.toString());
    	}
    	
    	for(int i = 0; i < remain.size(); i ++){
    		if(i > 0 && remain.get(i).equals(remain.get(i - 1))){
    			continue;
    		}
    		List<String> copy = new ArrayList<>(list);
    		copy.add(remain.get(i));
    		List<String> remaincopy = new ArrayList<>(remain);
    		remaincopy.remove(i);
    		permute(copy, remaincopy, odd);
    	}
    }
}