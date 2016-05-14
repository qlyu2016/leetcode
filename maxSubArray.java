package leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;




class Run{
	public static void main(String args[]){
		Solution test = new Solution();

        System.out.println(test.maxSubArray(nums));

	}
}

public class Solution {
    public int maxSubArray(int[] nums) {
    	int sum = nums[0];
        int max = nums[0];
        
        for(int i = 1; i < nums.length; i ++){
        	if(sum < 0){	
        		sum = 0;
        	}
        	
        	sum += nums[i];
        	
        	if(sum > max)
        		max = sum;
        }
        
        return max;
    }
}