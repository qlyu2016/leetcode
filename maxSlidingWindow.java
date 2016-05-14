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
		int[] nums = {1,3,-1,-3,5,3,6,7};
		int k = 3;
		int[] result = test.maxSlidingWindow(nums, k);
		for(int i = 0; i < result.length; i ++){
			System.out.print(result[i] + " ");
		}
	}
}

public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k){
    	if(nums.length == 0)
    		return new int[]{};
        int maxs = this.findMax(nums, 0, k - 1);
        int[] result = new int[nums.length - k + 1];
        result[0] = maxs;
        
    	for(int i = 1; i <= nums.length - k; i ++){
        	if(maxs > nums[i - 1]){
        		maxs = Math.max(maxs, nums[i + k - 1]);
        	}else{
        		maxs = this.findMax(nums, i, i + k - 1);
        	}
        	result[i] = maxs;
        }
    	
    	return result;
    }
    
    public int findMax(int[] nums, int start, int end){
    	int max = Integer.MIN_VALUE;
    	
    	for(int i = start; i <= end; i ++){
    		if(max < nums[i]){
    			max = nums[i];
    		}
    	}
    	
    	return max;
    }
}