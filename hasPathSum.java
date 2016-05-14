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

		TreeNode root = new TreeNode(-2);
//		root.left = new TreeNode(4);
		root.right = new TreeNode(-3);
//		root.left.left = new TreeNode(11);
//		root.right.left = new TreeNode(13);
//		root.right.right = new TreeNode(4);
//		root.left.left.left = new TreeNode(7);
//		root.left.left.right = new TreeNode(2);
//		root.right.right.right = new TreeNode(1);
		
		int sum = -5;
		System.out.println(test.hasPathSum(root, sum));
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
	private boolean result = false;
	
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null){
        	return false;
        }
    	pathSum(root, 0, sum);
        
        return this.result;
    }
    
    public void pathSum(TreeNode root, int sumToNow, int sum){
    	if(root.left == null && root.right == null){
    		if(sumToNow + root.val == sum){
    			this.result = true;
    		}
    	}
    	
    	if(root.left != null){
    		int temp = sumToNow;
    		temp += root.val;
    		pathSum(root.left, temp, sum);
    	}
    	
    	if(root.right != null){
    		int temp = sumToNow;
    		temp += root.val;
    		pathSum(root.right, temp, sum);
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