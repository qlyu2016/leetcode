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

		int[] nums = {0, 1, 0, 3, 12};
		test.moveZeroes(nums);
		
		for(int i = 0; i < nums.length; i ++){
		   System.out.print(nums[i] + " ");
		}
		
	}
}

public class Solution {
    public void moveZeroes(int[] nums) {
        List<Integer> result = new ArrayList<>();
        
        for(int i = 0; i < nums.length; i ++){
        	if(nums[i] != 0){
        		result.add(nums[i]);
        		nums[i] = 0;
        	}
        }
        
        for(int i = 0; i < result.size(); i ++){
        	nums[i] = result.get(i);
        }
        
    }
}