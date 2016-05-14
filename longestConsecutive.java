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

        int[] nums = new int[]{1,2,0,1};
        System.out.println(test.longestConsecutive(nums));
        
        
	}
}

public class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0){
        	return 0;
        }
        
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 1; i ++){
        	nums[i] = nums[i + 1] - nums[i];
        }
        
        int result = 1;
        int temp = 1;
        for(int i = 0; i < nums.length - 1; i ++){
        	if(nums[i] == 1){
        		temp ++;
        	}else if(nums[i] != 0){
        		temp = 1;
        	}
        	if(temp > result){
        		result = temp;
        	}
        }
        if(temp > result){
        	result = temp;
        }
        
        return result;
    }
}