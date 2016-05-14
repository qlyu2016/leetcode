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

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.right.right = new TreeNode(3);
		root.left.left.left = new TreeNode(4);
		root.right.right.right = new TreeNode(4);
		
		System.out.println(test.isBalanced(root));
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
    public boolean isBalanced(TreeNode root) {
        if(root == null)
        	return true;
        
    	if(Math.abs(depth(root.left) - depth(root.right)) > 1)
    		return false;
    	
    	if(isBalanced(root.left) && isBalanced(root.right))
    		return true;
    	else 
    		return false;
    		
    }
    
    public int depth(TreeNode root){
    	if(root == null)
    		return 0;
    	
    	return Math.max(depth(root.left), depth(root.right)) + 1;
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