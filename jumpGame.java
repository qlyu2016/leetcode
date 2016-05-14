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
 
		int[] nums = new int[]{2,3,1,1,4};
		
		System.out.println(test.jump(nums));
	}
}

public class Solution {
    public int jump(int[] nums) {
    	int[] count = new int[nums.length];
        if(nums.length <= 1){
        	return 0;
        }
        if(nums[0] == 0){
        	return -1;
        }
    	
        int maxCoverIndex = nums[0];
        int step = 0;
        int start = 0;
        
        for(; start < nums.length && start <= maxCoverIndex; ) {  
            ++ step;  
            if (maxCoverIndex >= nums.length - 1) {  
                return step;  
            }  
            int nextMax = 0;  
            for (int i = start; i <= maxCoverIndex; ++i) {  
                if ((i + nums[i]) > nextMax) {  
                    nextMax = i + nums[i];  
                    start = i;  
                }  
            }  
            maxCoverIndex = nextMax;  
        }  
        
        return -1;  
    }
}