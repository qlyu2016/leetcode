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
        
		int[] candidates = {10,1,2,7,6,1,5};
		int target = 8;
		
		List<List<Integer>> result = test.combinationSum2(candidates, target);
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
	List<List<Integer>> result = new ArrayList<>();
	
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        
        sum(candidates, 0, target, new ArrayList<Integer>());
        
        return result;
    }
    
    public void sum(int[] candidates, int start, int target, List<Integer> list){
    	if(target == 0){
    		result.add(list);
    		return ;
    	}
    	if(start == candidates.length){
    		return ;
    	}
    	
    	int now = target - candidates[start];
    	if(now >= 0){
    		if(start == 0 || (start > 0 && candidates[start] != candidates[start - 1]) 
    				|| (start > 0 && candidates[start] == candidates[start - 1]) 
    				&& count(candidates, start) == countList(list, candidates[start])){
    			List<Integer> copy = new ArrayList<>(list);
    			copy.add(candidates[start]);
    			sum(candidates, start + 1, now, copy);
    		}
    	}
    	
    	sum(candidates, start + 1, target, list);
    }
    
    public int count(int[] candidates, int position){
    	int result = 0;
    	for(int i = position; i >= 0; i --){
    		if(candidates[position] == candidates[i]){
    			result ++;
    		}else{
    			break;
    		}
    	}
    	
    	return result - 1;
    }
    
    public int countList(List<Integer> list, int target){
    	if(list.size() == 0){
    		return 0;
    	}
    	int result = 0;
    	
    	for(int i = list.size() - 1; i >= 0; i --){
    		if(list.get(i) == target){
    			result ++;
    		}else{
    			break;
    		}
    	}
    	
    	return result;
    }
}