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


class Run{
	public static void main(String args[]){
		Solution test = new Solution();

        int[] nums = {2,3,1,2,4,3};
        int s = 7;
        
        System.out.print(test.minSubArrayLen(s, nums));
		
	}
}

public class Solution {
	
    public int minSubArrayLen(int s, int[] nums) {
    	if(nums.length == 0){
    		return 0;
    	}
    	int result = Integer.MAX_VALUE;
    	boolean hasSum = false;
    	int start = 0;
    	int end = 0;
    	int sum = nums[0];
    	
        while(end < nums.length - 1 || sum >= s){
        	if(sum >= s){
        		hasSum = true;
        		while(sum >= s){
        			sum -= nums[start];
        			start ++;
        		}
        		if(result > end - start + 2){
        			result = end - start + 2;
        		}
        	}else{
        		end ++;
        		sum += nums[end];
        	}
        }
        
        if(!hasSum){
        	return 0;
        }else{
        	return result;
        }
    }
}