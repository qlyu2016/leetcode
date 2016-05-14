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
        
		int n = 32;
		
		List<List<Integer>> result = test.getFactors(n);
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
	
    public List<List<Integer>> getFactors(int n) {
    	factor(n, 2, new ArrayList<Integer>());
        
    	return this.result;
    }
    
    public void factor(int target, int start, List<Integer> list){
    	if(target == 1){
    		if(list.size() > 1){
    		   result.add(list);
    		}
    		return ;
    	}
    	
    	for(int i = start; i * i <= target; i ++){
    		if(target % i == 0){
    		     List<Integer> copy = new ArrayList<>(list);
    		     copy.add(i);
    		     factor(target / i, i, copy);
    		}
    	}
    	
    	list.add(target);
    	factor(1, target, list);
    }
}
