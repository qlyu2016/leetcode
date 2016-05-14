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

		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(9);
		root.right = new TreeNode(0);
		root.left.right = new TreeNode(1);
		
		System.out.println(test.sumNumbers(root));
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
	private List<List<Integer>> result = new ArrayList<>();
	
    public int sumNumbers(TreeNode root) {
    	if(root == null)
    		return 0;
    	
        onePath(root, new ArrayList<Integer>());
        int result = 0;
        
        for(int i = 0; i < this.result.size(); i ++){
        	List<Integer> item = this.result.get(i);
        	int temp = 0;
        	for(int j = 0; j < item.size(); j ++){
        		temp *= 10;
        		temp += item.get(j);
        	}
        	result += temp;
        }
        
        return result;
    }
    
    public void onePath(TreeNode root, List<Integer> list){
    	if(root.left == null && root.right == null){
    		list.add(root.val);
    		result.add(list);
    	}
    	
    	if(root.left != null){
    		List<Integer> copy = new ArrayList<>(list);
    		copy.add(root.val);
    		onePath(root.left, copy);
    	}
    	
    	if(root.right != null){
    		List<Integer> copy = new ArrayList<>(list);
    		copy.add(root.val);
    		onePath(root.right, copy);
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