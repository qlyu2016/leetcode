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
    public boolean canPermutePalindrome(String s) {
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
        
        for(String k : record.keySet()){
        	int temp = record.get(k);
        	if(temp % 2 == 1){
        		if(count == 0){
        		   count ++;
        		}else{
        			return false;
        		}
        	}
        }
        
        return true;
    }
}