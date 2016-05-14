package leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


class Run{
	public static void main(String args[]){
		Solution test = new Solution();

		int[] nums = {3, 1};
		int target = 1;
		System.out.print(test.search(nums, target));
		
	}
}

public class Solution {
    public int search(int[] nums, int target) {
        if(nums.length == 0)
        	return -1;
        if(nums.length == 1){
        	if(nums[0] == target)
        		return 0;
        	else
        		return -1;
        }
        int milestone = nums[0];
        int position = -1;
        
        for(int i = 0; i < nums.length; i ++){
        	if(nums[i] < milestone){
        		position = i;
        		break;
        	}
        }
        
        if(position == -1){
        	return searchInSub(nums, 0, nums.length - 1, target);
        }
        
        if(target < milestone){
        	int result;
        	if((result = searchInSub(nums, position, nums.length - 1, target)) != -1)
        	    return  result;
        	else
        		return -1;
        }else{
        	return searchInSub(nums, 0, position - 1, target);
        }
        
    }
    
    public int searchInSub(int[] nums, int start, int end, int target){
    	int left = start;
    	int right = end;
    	if(nums[start] == target)
    		return start;
    	if(nums[end] == target)
    		return end;
    	if(end - start <= 1)
    		return -1;
    	
    	int leftSub;
    	if(target < nums[(start + end) / 2]){
    		return searchInSub(nums, start, (start + end) / 2 - 1, target);
    	}else{
    		return searchInSub(nums, (start + end) / 2, end, target);
    	}
    }
}