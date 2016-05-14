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
		
		System.out.println(test.rob(nums));
		
	}
}

public class Solution {
    public int rob(int[] nums) {
        int[] dps = new int[nums.length + 1];
        if(nums.length == 0){
        	return 0;
        }
        if(nums.length == 1){
        	return nums[0];
        }
        if(nums.length == 2){
        	return (nums[0] > nums[1]) ? nums[0] : nums[1];
        }
        
        dps[1] = nums[0];
        dps[2] = nums[1];
        for(int i = 2; i < nums.length; i ++){
        	dps[i + 1] = Math.max(dps[i - 1], dps[i - 2]) + nums[i];
        }
        
        return (dps[nums.length] > dps[nums.length - 1]) ? dps[nums.length] : dps[nums.length - 1];
    }
}