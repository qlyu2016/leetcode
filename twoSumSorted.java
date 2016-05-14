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
import java.util.TreeSet;


class Run{
	public static void main(String args[]){
		Solution test = new Solution();
 
		int[] nums = new int[]{1,5,1};
		test.nextPermutation(nums);
		
		for(int i = 0; i < nums.length; i ++){
			System.out.print(nums[i]);
		}
	}
}

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
    	int[] index = new int[2];
    	int left = 0;
    	int right = numbers.length - 1;
    	
        for(; left <= right;){
        	if(numbers[left] + numbers[right] > target){
        		right --;
        	}else if(numbers[left] + numbers[right] < target){
        		left ++;
        	}else{
        		break;
        	}
        }
        
        index[0] = left + 1;
        index[1] = right + 1;
        
        return index;
    }
}