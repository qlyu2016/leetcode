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

		int[] nums = {2,2,3,2};
		
		System.out.println(test.singleNumber(nums));
	}
}

public class Solution {
    public int singleNumber(int[] nums){
    	if(nums.length == 0)
    		return 0;
    	
        Arrays.sort(nums);
        int count = 1;
        int number = nums[0];
        
        for(int i = 1; i < nums.length; i ++){
        	if(nums[i] != number){
        		if(count != 3)
        			return number;
        		number = nums[i];
        		count = 1;
        	}else{
        		count ++;
        	}
        }
        
        if(count != 3)
        	return number;
        else
        	return nums[nums.length - 1];
    }
}