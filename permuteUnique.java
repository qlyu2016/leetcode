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
        
		int[] nums = {1,-1,1,2,-1,2,2,-1};
		
		List<List<Integer>> result = test.permuteUnique(nums);
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
	private List<List<Integer>> result = new ArrayList<>();
	
    public List<List<Integer>> permuteUnique(int[] nums) {
    	Arrays.sort(nums);
        List<Integer> numbers = new ArrayList<>();
        for(int i = 0; i < nums.length; i ++){
        	numbers.add(nums[i]);
        }
        
        permute(new ArrayList<>(), numbers);
        
        return this.result;
    }
    
    public void permute(List<Integer> list, List<Integer> remain){
    	if(remain.size() == 0){
    		this.result.add(list);
    		return ;
    	}
    	
    	for(int i = 0; i < remain.size(); i ++){
    		if(i > 0 && remain.get(i) == remain.get(i - 1)){
    			continue;
    		}
    		List<Integer> copy = new ArrayList<>(list);
    		copy.add(remain.get(i));
    		List<Integer> remaincopy = new ArrayList<>(remain);
    		remaincopy.remove(i);
    		permute(copy, remaincopy);
    	}
    }
}