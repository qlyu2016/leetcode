package leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;




class Run{
	public static void main(String args[]){
		Solution test = new Solution();

		int[] nums = {1,5};
		int target = 4;
		
        System.out.println("[" + test.searchRange(nums, target)[0]
        		+ "," +  test.searchRange(nums, target)[1] + "]");
	}
}

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        int start = -1;
        int end = -1;
    	for(int i = 0; i < nums.length; i ++){
            if(target == nums[i]){
            	if((i == 0) || (i > 0 && nums[i - 1] != target)){
                    start = i;
            	}
            	if((i == nums.length - 1) || (i < nums.length && nums[i + 1] != target)){
            		end = i;
            	}
            }
        }
    	
    	result[0] = start;
    	result[1] = end;
        return result;
    }
}