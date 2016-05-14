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
import java.util.Set;
import java.util.Stack;
import java.util.Queue;


class Run{
	public static void main(String args[]){
		Solution test = new Solution();

        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        
        System.out.print(test.findMin(nums));
		
	}
}

public class Solution {
    public int findMin(int[] nums) {
        if(nums.length == 1)
        	return nums[0];
        
    	if(nums[0] > nums[nums.length - 1]){
        	int i = nums.length - 1;
    		while(nums[i] > nums[i - 1]){
        		i --;
        	}
    		return nums[i];
        }else{
        	return nums[0];
        }
    }
}