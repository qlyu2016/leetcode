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
    public void nextPermutation(int[] nums) {
        if(nums.length <= 1){
        	return;
        }
        
        int i = nums.length - 1;
        for(; i > 0; i --){
        	if(nums[i - 1] < nums[i]){
        		break;
        	}
        }
        
        int minpos = i;
        int min = nums[i];
        if(i > 0){
            for(int j = i; j < nums.length; j ++){
        	    if(nums[j] <= min && nums[j] > nums[i - 1]){
        		    min = nums[j];
        		    minpos = j;
        	    }
            }
        
            nums[minpos] = nums[i - 1];
            nums[i - 1] = min;
        }
        
        for(int left = i, right = nums.length - 1; left <= right; left ++, right --){
        	int temp = nums[left];
        	nums[left] = nums[right];
        	nums[right] = temp;
        }
        
    }
}