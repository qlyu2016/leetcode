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
        
		TreeNode root = new TreeNode(2);
		root.right = new TreeNode(3);
		double target = 3.428571;
		
		System.out.println(test.closestValue(root, target));
		
		
		
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
	private double diff = Double.MAX_VALUE;
	private int clost = Integer.MIN_VALUE;
	
    public int closestValue(TreeNode root, double target) {
        closest(root, target);
        return clost;
    }
    
    public void closest(TreeNode root, double target){
    	if(root == null){
    		return ;
    	}
    	if(root.val == target){
    		diff = 0;
    		clost = root.val;
    		return ;
    	}
    	
    	if(Math.abs(target - (double)(root.val)) < diff){
    		this.diff = Math.abs(target - (int)(root.val));
    		clost = root.val;
    	}
    	
    	closest(root.left, target);
    	closest(root.right, target);
    }
}