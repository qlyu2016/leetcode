package leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


class Run{
	public static void main(String args[]){
		Solution test = new Solution();

		int[] nums = {1,1,2,2,3};
		System.out.println(test.singleNumber(nums));
	}
}

public class Solution {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length / 2; i ++){
        	if(nums[2 * i] != nums[2 * i + 1])
        		return nums[2 * i];
        }
        
        return nums[nums.length - 1];
        
    }
}