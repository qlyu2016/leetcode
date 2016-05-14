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
	int[] temp;
	
    public int findKthLargest(int[] nums, int k) {
        temp = new int[k];
        for(int i = 0; i < k; i ++){
        	temp[i] = nums[i];
        }
        
        Arrays.sort(temp);
        
        for(int i = k; i < nums.length; i ++){
        	if(nums[i] > temp[0]){
        		temp[0] = nums[i];
        		Arrays.sort(temp);
        	}
        }
        
        return temp[0];
    }
}