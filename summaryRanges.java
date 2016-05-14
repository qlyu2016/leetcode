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

		int[] nums = {0,5,9};
		List<String> result = test.summaryRanges(nums);
		for(int i = 0; i < result.size(); i ++){
			System.out.print(result.get(i) + " ");
		}
	}
}

public class Solution {
    public List<String> summaryRanges(int[] nums) {
    	List<String> result = new ArrayList<>();
    	if(nums.length == 0)
    		return result;
    	if(nums.length == 1){
    		result.add(String.valueOf(nums[0]));
    		return result;
    	}
    	int pre = nums[0];
    	
        for(int i = 1; i < nums.length; i ++){
        	if(nums[i] - nums[i - 1] == 1){
        		if(i == nums.length - 1){
        			StringBuffer temp = new StringBuffer("");
        			temp.append(String.valueOf(pre));
        			temp.append("->");
        			temp.append(String.valueOf(nums[i]));
        			result.add(temp.toString());
        		}
        	}else{
        		if(nums[i - 1] != pre){
        			StringBuffer temp = new StringBuffer("");
        			temp.append(String.valueOf(pre));
        			temp.append("->");
        			temp.append(String.valueOf(nums[i - 1]));
        			result.add(temp.toString());
        			if(i != nums.length - 1)
        			   pre = nums[i];
        			else{
        				result.add(String.valueOf(nums[i]));
        			}
        		}else{
        			result.add(String.valueOf(nums[i - 1]));
        			if(i == nums.length - 1)
        				result.add(String.valueOf(nums[i]));
        			else
        				pre = nums[i];
        		}
        	}
        }
        
        return result;
    }
}