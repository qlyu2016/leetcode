package leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;


class Run{
	public static void main(String args[]){
		Solution test = new Solution();

//        int[] height = {2,1,5,6,2,3};
//        System.out.println(test.largestRectangleArea(height));
	}
}

public class Solution {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length - 1; i ++){
        	if(nums[i] == nums[i + 1])
        		return true;
        }
        
        return false;
    }
}