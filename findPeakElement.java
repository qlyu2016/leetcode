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
import java.util.Stack;
import java.util.Queue;


class Run{
	public static void main(String args[]){
		Solution test = new Solution();

		int[] nums = {1,2,3,1};
		
		System.out.println(test.findPeakElement(nums));
	}
}

public class Solution {
    public int findPeakElement(int[] nums) {
    	if(nums.length == 1){
    		return 0;
    	}
    	
        for(int i = 0; i < nums.length; i ++){
        	if(i > 0 && i < nums.length - 1){
        		if(nums[i - 1] < nums[i] && nums[i] > nums[i + 1]){
        			return i;
        		}
        	}else if(i == 0){
        		if(nums[i] > nums[i + 1]){
        			return i;
        		}
        	}else{
        		if(nums[i - 1] < nums[i]){
        			return i;
        		}
        	}
        }
        
        return Integer.MIN_VALUE;
    }
}