package leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;




class Run{
	public static void main(String args[]){
		Solution test = new Solution();

        int[] nums = {0,2,1,2,1,0,0,1};
        test.sortColors(nums);
        
        for(int i = 0; i < nums.length; i ++){
            System.out.print(nums[i] + " ");
        }

	}
}

public class Solution {
    public void sortColors(int[] nums) {
    	
        for(int i = 0; i < nums.length; i ++){
        	for(int j = nums.length - 1; j > i; j --){
        		if(nums[j - 1] > nums[j]){
        			int temp = nums[j - 1];
        			nums[j - 1] = nums[j];
        			nums[j] = temp;
        		}
        	}
        }
    }
}