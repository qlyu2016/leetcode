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

		int[] nums = {1,1,1,1,2,3};
		
		System.out.println(test.majorityElement(nums));
	}
}

public class Solution {
	private HashMap<Integer, Integer> record = new HashMap<>();
	
    public int majorityElement(int[] nums) {
        int result = 0;
        if(nums.length == 0)
        	return result;
        if(nums.length == 1)
        	return nums[0];
        int prob = nums.length / 2;
        
        for(int i = 0; i < nums.length; i ++){
        	if(record.get(nums[i]) == null){
        		record.put(nums[i], 1);
        	}else{
        		int count = record.get(nums[i]);
        		record.put(nums[i], count + 1);
        		if(count + 1 > prob){
        			return nums[i];
        		}
        	}
        }
        
        return 0;
    }
}