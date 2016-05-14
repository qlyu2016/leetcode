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
//		Solution test = new Solution();

//        char[][] board = {
//        		  {'A','B','C','E'},
//        		  {'S','F','C','S'},
//        		  {'A','D','E','E'}
//        };
//        String word = "ABCCED";
//		System.out.println(test.exist(board, word));
        
		int[] nums = {-2,0,3,-5,2,-1};
		NumArray temp = new NumArray(nums);
		
		System.out.println(temp.sumRange(0, 2));
		System.out.println(temp.sumRange(2, 5));
		System.out.println(temp.sumRange(0, 5));
		
	}
}

public class NumArray {
    private int[] sums;
    
    public NumArray(int[] nums) {
    	if(nums.length == 0){
    		return ;
    	}
    	sums = new int[nums.length];
    	sums[0] = nums[0];
    	
        for(int i = 1; i < nums.length; i ++){
        	sums[i] = nums[i] + sums[i - 1];
        }
    }

    public int sumRange(int i, int j) {
    	if(i >= sums.length || j >= sums.length){
    		return 0;
    	}
    	
    	if(i > 0)
    	    return sums[j] - sums[i - 1];
    	else
    		return sums[j];
    }
}