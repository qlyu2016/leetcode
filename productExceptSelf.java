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

		int[] nums = {1,2,3,4};
		int[] result = test.productExceptSelf(nums);
		for(int i = 0; i < result.length; i ++){
		    System.out.print(result[i] + " ");
		}
		
	}
}

public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        
        result[nums.length - 1] = 1;
        for(int i = nums.length - 2; i >= 0; i --){
        	result[i] = result[i + 1] * nums[i + 1];
        }
        
        int left = 1;
        for(int i = 1; i < nums.length; i ++){
        	left = left * nums[i - 1];
        	result[i] *= left;
        }
        
        return result;
    }
}