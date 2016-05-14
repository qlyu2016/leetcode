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
 
		int[] nums = new int[]{5, 4, 3, 2, 1};
		
		System.out.println(test.increasingTriplet(nums));
	}
}

public class Solution {
    public boolean increasingTriplet(int[] nums) {
        int[] length = new int[nums.length];
        if(nums.length <= 2){
        	return false;
        }
        
        for(int i = 0; i < nums.length; i ++){
        	for(int j = 0; j < i; j ++){
        		if(nums[j] < nums[i]){
        			length[i] = (length[j] + 1) > length[i] ? (length[j] + 1) : length[i];
        		}
        	}
        	if(length[i] == 0){
        		length[i] = 1;
        	}
        	if(length[i] == 3){
        		return true;
        	}
        }
        
        return false;
    }
}