package leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;




class Run{
	public static void main(String args[]){
		Solution test = new Solution();

		int[] nums = {1,3,5,6};
		int target = 5;
		
        System.out.println(test.searchInsert(nums, target));
	}
}

public class Solution {
    public int searchInsert(int[] nums, int target) {
        for(int i = 0; i < nums.length; i ++){
        	if(i == 0 && target <= nums[0])
        		return 0;
            if(i == nums.length - 1 && target > nums[i]){
            	return nums.length;
            }
        	if((i + 1) < nums.length && target > nums[i] && target <= nums[i + 1]){
        		return i + 1;
        	}
        }
        return -1;
    }
}