package leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;




class Run{
	public static void main(String args[]){
		Solution test = new Solution();

		int[] nums = {3,4,-1,1};
        System.out.println(test.firstMissingPositive(nums));

	}
}

public class Solution {
    public int firstMissingPositive(int[] nums) {
        int result = 1;
        
        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length; i ++){
        	if(nums[i] == result)
        		result ++;
        }
        
        return result;
    }
}