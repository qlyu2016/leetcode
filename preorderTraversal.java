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
//		root.left = new TreeNode(2);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(3);
//		root.left.left = new TreeNode(2);
//		root.left.left.left = new TreeNode(1);
//		root.left.left.right = new TreeNode(4);
//		root.left.left.right.left = new TreeNode(3);
		
		List<Integer> result = test.preorderTraversal(root);
		for(int i = 0; i < result.size(); i ++){
			System.out.print(result.get(i));
		}
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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        
        Stack<TreeNode> record = new Stack();
        if(root == null)
        	return result;
        
        TreeNode tail = root;
        result.add(tail.val);
        record.push(tail);
        while(record.size() > 0){
        	if(tail.left != null){
        		tail = tail.left;
        		record.push(tail);
        		result.add(tail.val);
        	}else{
//        		result.add(tail.val);
        		tail = record.pop();
        		while(tail.right == null && record.size() > 0){
        			tail = record.pop();
        		}
        		tail = tail.right;
        		if(tail != null){
        		    record.push(tail);
        		    result.add(tail.val);
        		}
        	}
        }
        
        return result;
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