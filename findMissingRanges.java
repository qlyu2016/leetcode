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

//        char[][] board = {
//        		  {'A','B','C','E'},
//        		  {'S','F','C','S'},
//        		  {'A','D','E','E'}
//        };
//        String word = "ABCCED";
//		System.out.println(test.exist(board, word));
        
		int[] nums = {};
		int lower = 1;
		int upper = 1;
		
		List<String> result = test.findMissingRanges(nums, lower, upper);
		for(int i = 0; i < result.size(); i ++){
			System.out.println(result.get(i));
		}
	}
}

public class Solution {
	private static int LEFT = 0;
	private static int MIDDLE = 1;
	private static int RIGHT = 2;
	
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<>();
        String temp;
        if(nums.length == 0){
        	if(upper - lower == 0){
            	result.add(String.valueOf(upper));
            }else{
            	result.add(String.valueOf(lower).concat("->").concat(String.valueOf(upper)));
            }
        	return result;
        }
        
    	if((temp = missing(lower, nums[0], this.LEFT)) != null){
        	result.add(temp);
        }
    	
    	for(int i = 0; i < nums.length - 1; i ++){
        	if((temp = missing(nums[i], nums[i + 1], this.MIDDLE)) != null){
        		result.add(temp);
        	}
        }
    	
    	if((temp = missing(nums[nums.length - 1], upper, this.RIGHT)) != null){
        	result.add(temp);
        }
    	
    	return result;
    }
    
    public String missing(int left, int right, int mark){
    	if(mark == this.LEFT){
    		if(right - left <= 0){
    			return null;
    		}else if(right - left == 1){
    			return String.valueOf(left);
    		}else{
    			return String.valueOf(left).concat("->").concat(String.valueOf(right - 1));
    		}
    	}else if(mark == this.MIDDLE){
    	    if(right - left <= 1){
    		     return null;
    	    }else if(right - left == 2){
    		     return String.valueOf(left + 1);
    	    }else{
    		     return String.valueOf(left + 1).concat("->").concat(String.valueOf(right - 1));
    	    }
    	}else{
    		if(right - left <= 0){
    			return null;
    		}else if(right - left == 1){
    			return String.valueOf(right);
    		}else{
    			return String.valueOf(left + 1).concat("->").concat(String.valueOf(right));
    		}
    	}
    }
}