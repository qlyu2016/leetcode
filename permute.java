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

//		TreeNode root = new TreeNode(1);
//		root.left = new TreeNode(2);
//		root.right = new TreeNode(2);
//		root.right.left = new TreeNode(3);
//		root.left.left = new TreeNode(2);
//		root.left.left.left = new TreeNode(1);
//		root.left.left.right = new TreeNode(4);
//		root.left.left.right.left = new TreeNode(3);
		
		int[] nums = {1,2,3};
		
		List<List<Integer>> result = test.permute(nums);
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
	
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> allNum = new ArrayList<>();
        
        for(int i = 0; i < nums.length; i ++){
        	allNum.add(nums[i]);
        }
        
        permute(allNum, new ArrayList<>());
        
        return result;
    }
    
    public void permute(List<Integer> allNum, List<Integer> list){
    	if(allNum.size() == 0){
    		result.add(list);
    	}
    	
    	for(int i = 0; i < allNum.size(); i ++){
    		List<Integer> temp = new ArrayList<>(allNum);
    		temp.remove(i);
    		List<Integer> copy = new ArrayList<>(list);
    		copy.add(allNum.get(i));
    		permute(temp, copy);
    	}
    }
}