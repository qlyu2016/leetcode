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

		int[] nums = {1,1,1,1,2,2};
		int count = test.removeDuplicates(nums);
        System.out.println(count);
        for(int i = 0; i < count; i ++){
        	System.out.print(nums[i] + " ");
        }
	}
}

public class Solution {
	List<Integer> temp = new ArrayList<>();
	
    public int removeDuplicates(int[] nums) {
        int result = 0;
        int repeatNumber = Integer.MAX_VALUE;
        int repeatCount = 0;
        
    	for(int i = 0; i < nums.length; i ++){
    		if(nums[i] != repeatNumber){
    			repeatNumber = nums[i];
    			result ++;
    			repeatCount = 1;
    			temp.add(nums[i]);
    		}else if(nums[i] == repeatNumber && repeatCount < 2){
    			result ++;
    			repeatCount ++;
    			temp.add(nums[i]);
    		}else{
    			repeatCount ++;
    		}
    	}
    	
    	for(int i = 0; i < result; i ++){
    		nums[i] = temp.get(i);
    	}
    	
    	return result;
    }
}