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
		root.left.left = new TreeNode(3);
//		root.left.left = new TreeNode(2);
//		root.left.left.left = new TreeNode(1);
//		root.left.left.right = new TreeNode(4);
//		root.left.left.right.left = new TreeNode(3);
		
		test.flatten(root);
		inOrder(root);
	}
	
	public static void inOrder(TreeNode root){
		if(root == null)
			return ;
		
		System.out.print(root.val + " ");
		inOrder(root.left);
		inOrder(root.right);
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
    public void flatten(TreeNode root) {
        if(root == null)
        	return ;
    	
    	if(root.left != null){
        	TreeNode right = root.right;
        	root.right = root.left;
        	root.left = null;
        	TreeNode tail = root.right;
        	while(tail.right != null){
        		tail = tail.right;
        	}
        	tail.right = right;
        	flatten(root.right);
        }else{
        	flatten(root.right);
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