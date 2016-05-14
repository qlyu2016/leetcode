package leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;




class Run{
	public static void main(String args[]){
		Solution test = new Solution();

		int target = 82;
		int[] nums = {1,2,4,8,16,32,64,128};
		
        System.out.println(test.threeSumClosest(nums, target));
	}
}

public class Solution {
	private int distance;
	private int result = Integer.MAX_VALUE;
	
    public int threeSumClosest(int[] nums, int target) {
    	this.distance = Math.abs(nums[0] + nums[1] + nums[2] - target) + 1;
    	Arrays.sort(nums);
         
        for(int i = 0; i < nums.length - 2; i ++){
        	if(i > 0 && nums[i] == nums[i - 1]) continue;
        	find(nums, i + 1, nums.length - 1, nums[i], target);
        } 
        
        return result;
    }
    
    public void find(int[] nums, int begin, int end, int first, int target){
    	int left = begin;
    	int right = end;
    	
    	while(left < right){
    		if(left > begin && nums[left] == nums[left - 1]){
    			left ++;
    			continue;
    		}
    		
    		if(right < end && nums[right] == nums[right + 1]){
    			right --;
    			continue;
    		}
    		
    		if(first + nums[left] + nums[right] == target){
    			this.distance = 0;
    			this.result = target;
    			return ;
    		}else if(first + nums[left] + nums[right] < target){
    			if(Math.abs(first + nums[left] + nums[right] - target) < this.distance){
    				this.result = first + nums[left] + nums[right];
    				this.distance = Math.abs(first + nums[left] + nums[right] - target);
    			}
    			left ++;
    		}else{
    			if(Math.abs(first + nums[left] + nums[right] - target) < this.distance){
    				this.result = first + nums[left] + nums[right];
    				this.distance = Math.abs(first + nums[left] + nums[right] - target);
    			}
    			right --;
    		}
    	}
    	
    }
}