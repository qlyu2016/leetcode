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

        int[] nums = {1,1,1};
        
        List<Integer> result = test.majorityElement(nums);
        for(int i = 0; i < result.size(); i ++){
        	System.out.print(result.get(i) + " ");
        }
		
	}
}

public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if(nums.length == 0){
        	return result;
        }
    	int length = nums.length / 3 + 1;
    	Arrays.sort(nums);
    	int start = 0;
    	int end = 0;
    	
    	while(start < nums.length && end < nums.length){
    		if(nums[start] == nums[end]){
    			if(end - start + 1 >= length && !result.contains(nums[start])){
    				result.add(nums[start]);
    			}
    			end ++;
    		}else{
    			start = end;
    		}
    	}
    	
    	return result;
    }
}