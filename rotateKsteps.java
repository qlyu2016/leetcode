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

		int[] nums = {1,2,3};
		int k = 1;
		test.rotate(nums, k);
		for(int i = 0; i < nums.length; i ++){
			System.out.print(nums[i] + " ");
		}
	}
}

public class Solution {
    public void rotate(int[] nums, int k) {
    	if(k > nums.length)
    		k = k % nums.length;
    	
        List<Integer> temp = new ArrayList<>();
        
        for(int i = 0; i < k; i ++){
        	temp.add(nums[nums.length - k + i]);
        }
        
        for(int i = 0; i < nums.length - k; i ++){
        	temp.add(nums[i]);
        }
        
    	for(int i = 0; i < nums.length; i ++){
        	nums[i] = temp.remove(0);
        }
    	
    }
}