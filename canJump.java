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
        
		int[] nums = {2,3,1,1,4};
		
		System.out.println(test.canJump(nums));
		
	}
}

public class Solution {
    public boolean canJump(int[] nums) {
        int max = 0;
        int step = 1;
        if(nums.length<=1)	
        	return true;
        
        if(nums[0] == 0 && nums.length > 1) 
        	return false;
        
        for(int i = 0;i < nums.length;i++){
            step --;
            if(i + nums[i] > max){
               max = i + nums[i];
               step = nums[i];
            }
            
            if(step == 0 && i < nums.length - 1)	
            	return false;

        }
        return true;
    }
}