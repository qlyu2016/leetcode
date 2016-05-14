package leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Stack;
import java.util.Queue;


class Run{
	public static void main(String args[]){
		Solution test = new Solution();

		int[] nums = {1, 2, 1, 3, 2, 5};
		
		int[] result = test.singleNumber(nums);
		for(int i = 0; i < result.length; i ++){
			System.out.print(result[i] + " ");
		}
	}
}

public class Solution {
    public int[] singleNumber(int[] nums) {
        if(nums.length == 0)
        	return null;
        
    	Arrays.sort(nums);
        List<Integer> result = new ArrayList<>();
        int count = 1;
        int number = nums[0];
        
        for(int i = 1; i < nums.length; i ++){
        	if(number != nums[i]){
        		if(count == 1){
        			result.add(number);
        		}
        		count = 1;
        		number = nums[i];
        	}else{
        		count ++;
        	}
        }
        if(count == 1){
			result.add(number);
		}
        
        int[] res = new int[2];
        res[0] = result.get(0); res[1] = result.get(1);
        
        return res;
    }
}