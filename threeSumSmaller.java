package leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
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
 
		int[] nums = new int[]{1,-2,2,1,0};
		int target = 1;
		
		System.out.println(test.threeSumSmaller(nums, target));
		
		
	}
}

public class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        if(nums.length <= 2){
        	return 0;
        }
        Arrays.sort(nums);
        int result = 0;
        
        for(int i = 0; i < nums.length && 3 * nums[i] <= target; i ++){
        	int left = i + 1;
        	int right = nums.length - 1;
        	while(left < right){
        		int sum = nums[i] + nums[left] + nums[right];
        		if(sum >= target){
        			right --;
        		}else{
        			result += right - left;
        		    left ++;
        		}
        	}
        }
        
        return result;
    }
}
