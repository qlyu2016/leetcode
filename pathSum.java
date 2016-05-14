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

		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(11);
		root.right.left = new TreeNode(13);
		root.right.right = new TreeNode(4);
		root.left.left.left = new TreeNode(7);
		root.left.left.right = new TreeNode(2);
		root.right.right.left = new TreeNode(5);
		root.right.right.right = new TreeNode(1);
		
		int sum = 22;
		List<List<Integer>> result = test.pathSum(root, sum);
		for(int i = 0; i < result.size(); i ++){
			List<Integer> temp = result.get(i);
			for(int j = 0; j < temp.size(); j ++){
				System.out.print(temp.get(j) + " ");
			}
			System.out.println();
		}
	}
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
	List<List<Integer>> result = new ArrayList<>();
	
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root == null)
        	return result;
        
        pathSum(root, new ArrayList<>(), 0, sum);
        
        return result;
    }
    
    public void pathSum(TreeNode root, List<Integer> list, int sumToNow, int sum){
    	if(root.left == null && root.right == null){
    		if(sumToNow + root.val == sum){
    			list.add(root.val);
    			this.result.add(list);
    		}
    	}
    	
    	if(root.left != null){
    		int temp = sumToNow;
    		temp += root.val;
    		List<Integer> copy = new ArrayList<>(list);
    		copy.add(root.val);
    		pathSum(root.left, copy, temp, sum);
    	}
    	
    	if(root.right != null){
    		int temp = sumToNow;
    		temp += root.val;
    		List<Integer> copy = new ArrayList<>(list);
    		copy.add(root.val);
    		pathSum(root.right, copy, temp, sum);
    	}
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
