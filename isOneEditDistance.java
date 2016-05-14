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
        
		String s = "ab";
		String t = "abc";
		
		System.out.println(test.isOneEditDistance(s, t));
	}
}

public class Solution {
    public boolean isOneEditDistance(String s, String t){
    	if(s.length() == 0 && t.length() == 0 || s.equals(t)){
    		return false;
    	}
    	if(s.length() > t.length()){
    		String temp = s;
    		s = t;
    		t = temp;
    	}
    	
        if(t.length() - s.length() >= 2){
        	return false;
        }else if(t.length() - s.length() == 1){
        	int count = 0;
        	for(int i = 0; i < s.length(); i ++){
        		if(count == 0){
        			if(s.charAt(i) != t.charAt(i)){
        				String temp = t.substring(0, i);
        				temp = temp.concat(t.substring(i + 1, t.length()));
        				if(s.equals(temp)){
        					return true;
        				}else{
        					return false;
        				}
        			}
        		}
        	}
        	
        	return true;
        }else{
        	int count = 0;
        	for(int i = 0; i < s.length(); i ++){
        		if(s.charAt(i) != t.charAt(i)){
        			count ++;
        			if(count >= 2){
        				return false;
        			}
        		}
        	}
        	
        	return true;
        }
    }
}