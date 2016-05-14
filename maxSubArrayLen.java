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
        
		int[] nums = {-1,1};
		int k = 1;
		
		System.out.println(test.maxSubArrayLen(nums, k));
	}
}

public class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        int[] sums = new int[nums.length];
        if(nums.length == 0){
        	return 0;
        }
        if(nums.length == 1){
        	if(nums[0] == k){
        		return 1;
        	}else{
        		return 0;
        	}
        }
        
        sums[0] = nums[0];
    	for(int i = 1; i < nums.length; i ++){
    		sums[i] = sums[i - 1] + nums[i]; 
    	}
    	
    	int result = 0;
    	for(int i = 0; i < sums.length; i ++){
    		for(int j = i; j < sums.length; j ++){
    			if(i == 0){
    				if(sums[j] == k && j + 1 > result){
    					result = j + 1;
    				}
    			}else{
    				if(sums[j] - sums[i - 1] == k && j - i + 1 > result){
    					result = j - i + 1;
    				}
    			}
    		}
    	}
    	
    	return result;
    }
}