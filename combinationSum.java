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

		int[] candidates = {2,3,6,7};
		int target = 7;
		
		List<List<Integer>> result = test.combinationSum(candidates, target);
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
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        
        Arrays.sort(candidates);
        recursion(new ArrayList<Integer>(), target, candidates, 0, result);
        
        return result;
    }
    
    private void recursion(List<Integer> list, int target, int[] candidates, int index, List<List<Integer>> result){
    	if(target == 0){
    		result.add(list);
    		return ;
    	}
    	
    	for(int i = index; i < candidates.length; i ++){
    		int newtarget = target - candidates[i];
    		if(newtarget >= 0){
    			List<Integer> copy = new ArrayList<>(list);
    		    copy.add(candidates[i]); 
    			recursion(copy, newtarget, candidates, i, result);
    		}else{
    			break;
    		}
    	}
    		
    }
}