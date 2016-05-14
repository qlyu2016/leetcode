package leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;




class Run{
	public static void main(String args[]){
		Solution test = new Solution();
        
		int[] nums = {2};
		int val = 3;
		
        System.out.println(test.removeElement(nums, val));

	}
}

public class Solution {
    public int removeElement(int[] nums, int val) {
    	if(nums.length == 0)
    		return 0;
    	
    	Arrays.sort(nums);
    	int begin = -1;
    	int end = -1;
    	
        for(int i = 0; i < nums.length; i ++){
           if(nums[i] == val){
        	   if(i == 0 || (i > 0 && nums[i] != nums[i - 1])){
        		   begin = i;
        	   }
        	   if(i == nums.length - 1 || (i < nums.length - 1 && nums[i] != nums[i + 1])){
        		   end = i;
        	   }
           }
        }
        if(end != -1 && begin <= end){
        	for(int i = 0; i < nums.length - 1 - end; i ++){
        		nums[begin + i] = nums[i + end + 1];
        	}
        	
//        	for(int i = 0; i < nums.length - (end - begin + 1); i ++){
//        	    System.out.print(nums[i] + " ");
//            }
        	
        	return nums.length - (end - begin + 1);
        }else{
        	
        	return nums.length;
        }
        
    }
}