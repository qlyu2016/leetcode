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

        
	}
}

public class Solution {
	private List<Integer> number = new ArrayList<>();
	
    public int removeDuplicates(int[] nums) {
        
    	for(int i = 0; i < nums.length; i ++){
        	if(!number.contains(nums[i])){
        		number.add(nums[i]);
        	}
        }
    	
    	for(int i = 0; i < number.size(); i ++){
    		nums[i] = number.get(i);
    	}
    	
    	return number.size();
    }
}