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

        int[] nums = {4,5,6,7,0,0,1,1,2,3};
        
        System.out.print(test.findMin(nums));
		
	}
}

public class Solution {
	
    public int findMin(int[] nums){
        int result = Integer.MAX_VALUE;
        	
        for(int i = 0; i < nums.length; i ++){
        	if(result > nums[i]){
        		result = nums[i];
        	}
        }
        
        return result;
    }
}