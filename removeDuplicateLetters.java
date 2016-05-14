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
        
		int[] nums = {2,1,1,2};
		
		String s = "bcabc";
		System.out.println(test.removeDuplicateLetters(s));
		
	}
}

public class Solution{
public String removeDuplicateLetters(String s) {  
    int[] count = new int[26];  
    int pos = 0;  
    for(int i = 0; i < s.length(); i ++) 
    	count[s.charAt(i) - 'a'] ++;  
    
    for(int i = 0; i < s.length(); i ++) {  
        if(s.charAt(i) < s.charAt(pos)) 
        	pos = i;  
        if(-- count[s.charAt(i) - 'a'] == 0) 
        	break;  
    }  
    
    return s.length() == 0? "" : s.charAt(pos) + 
    		removeDuplicateLetters(s.substring(pos+1).replaceAll("" + s.charAt(pos), ""));  
}  
}