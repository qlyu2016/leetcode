package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Solution {
    public static int[] twoSum(int[] nums, int target) {
		
    	List<Integer> now = new ArrayList();
    	for(int i = 0; i < nums.length; i ++){
    		now.add(nums[i]);
    	}
    	int tagt = target;
    	int result[] = null;
    	result = new int[2];
    	
    	for(int i = 0; i < now.size(); i ++){
    		for(int j = i + 1; j < now.size(); j ++){
    			if((now.get(i).intValue() + now.get(j).intValue()) == tagt){
    				result[0] = i + 1;
    				result[1] = j + 1;
    				
    				return result;
    			}
    		}
    	}
		return null;
    }
    
    public static void main(String args[]){
    	int a[] = {3,2,4};
    	int[] b = twoSum(a, 6);
    	System.out.print(b[0] + " " + b[1]);
    }
}