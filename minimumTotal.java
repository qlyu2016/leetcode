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

		List<List<Integer>> triangle = new ArrayList<>();
		List<Integer> temp = new ArrayList<>();
		temp.add(2);
		triangle.add(temp);
		temp = new ArrayList<>();
		temp.add(3);temp.add(4);
		triangle.add(temp);
		temp = new ArrayList<>();
		temp.add(5);temp.add(5);temp.add(7);
		triangle.add(temp);
		temp = new ArrayList<>();
		temp.add(4);temp.add(1);temp.add(8);temp.add(3);
		triangle.add(temp);
		
		System.out.println(test.minimumTotal(triangle));
	}
}

public class Solution {
	int min = Integer.MAX_VALUE;
	
    public int minimumTotal(List<List<Integer>> triangle) {
    	if(triangle.size() == 0)
    		return 0;
    	List<List<Integer>> result = new ArrayList<>();
    	
    	for(int i = 0; i < triangle.size(); i ++){
    		List<Integer> temp = triangle.get(i);
    		if(i == 0){
    			result.add(new ArrayList<>());
    			result.get(0).add(temp.get(0));
    		}else{
    			result.add(new ArrayList<>());
    			for(int j = 0; j < temp.size(); j ++){
    				if(j == 0){
    					result.get(i).add(result.get(i - 1).get(0) + temp.get(0));
    				}else if(j == temp.size() - 1){
    					result.get(i).add(result.get(i - 1).get(j - 1) + temp.get(j));
    				}else{
    					int left = result.get(i - 1).get(j - 1);
    					int right = result.get(i - 1).get(j);
    					if(left < right){
    						result.get(i).add(left + temp.get(j));
    					}else{
    						result.get(i).add(right + temp.get(j));
    					}
    				}
    			}
    		}
    	}
    	
    	List<Integer> temp = result.get(result.size() - 1);
    	for(int i = 0; i < temp.size(); i ++){
    		if(min > temp.get(i)){
    			min = temp.get(i);
    		}
    	}
    	
    	return min;
    }
    

}


class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x){
		val = x;
	}
}