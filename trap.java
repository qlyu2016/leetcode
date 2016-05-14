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
        
		int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
		
		
		System.out.println(test.trap(height));
		
	}
}

public class Solution {
    public int trap(int[] height) {
        int max = -1;
        int maxIndex = 0;
    	int result = 0;
        
    	for(int i = 0; i < height.length; i ++){
    	     if(height[i] > max){
    	    	 max = height[i];
    	    	 maxIndex = i;
    	     }
    	}
    	
    	int secHeight = 0;
    	for(int i = 0; i < maxIndex; i ++){
    		if(height[i] > secHeight){
    			secHeight = height[i];
    		}else{
    			result += secHeight - height[i];
    		}
    	}
    	
    	secHeight = 0;
    	for(int i = height.length - 1; i > maxIndex; i --){
    		if(height[i] > secHeight){
    			secHeight = height[i];
    		}else{
    			result += secHeight - height[i];
    		}
    	}
    	
    	return result;
    }
}