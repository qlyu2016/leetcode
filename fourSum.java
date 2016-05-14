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
 
		int[] nums = new int[]{1,0,-1,0,-2,2};
		int target = 0;
		
		List<List<Integer>> result = test.fourSum(nums, target);
		
		for(int i = 0; i < result.size(); i ++){
			List<Integer> temp = result.get(i);
			for(int j = 0; j < temp.size(); j ++){
				System.out.print(temp.get(j) + " ");
			}
			System.out.println();
		}
	}
}

public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        
        if(nums.length == 0){
        	return result; 
        }
        Set res = new HashSet();
        for(int i = 0; i < nums.length; i ++){
        	for(int j = i + 1; j < nums.length; j ++){
        		int left = j + 1;
        		int right = nums.length - 1;
        		while(left < right){
        			int sum = nums[i] + nums[j] + nums[left] + nums[right];
        			if(sum == target){
        				List<Integer> temp = new ArrayList<>();
        				temp.add(nums[i]);
        				temp.add(nums[j]);
        				temp.add(nums[left]);
        				temp.add(nums[right]);
                        res.add(temp);
        				left ++;
        				right --;
        			}else if(sum > target){
        				right --;
        			}else{
        				left ++;
        			}
        		}
        	}
        }
        
        Iterator it = res.iterator();
        while(it.hasNext()){
        	result.add((List<Integer>)it.next());
        }
        
        return result;
    }
    
}