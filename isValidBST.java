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


class Run{
	public static void main(String args[]){
		Solution test = new Solution();

        TreeNode root = new TreeNode(5);
        root.left  = new TreeNode(14);
//        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
//        root.right.right = new TreeNode(20);
        
        System.out.print(test.isValidBST(root));
		
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
    public boolean isValidBST(TreeNode root) {
        if(root == null){
        	return true;
        }
        
        boolean leftSub = true;
        if(root.left != null){
        	int left = maxElem(root.left);
        	if(left < root.val){
        		leftSub = isValidBST(root.left);
        	}else{
        		return false;
        	}
        }
        
        boolean rightSub = true;
        if(root.right != null){
        	int right = minElem(root.right);
        	if(right > root.val){
        		rightSub = isValidBST(root.right);
        	}else{
        		return false;
        	}
        }
        
        if(leftSub && rightSub){
        	return true;
        }else{
        	return false;
        }
    }
    
    
    public int minElem(TreeNode root){
    	if(root == null)
    		return Integer.MAX_VALUE;
    	int min = root.val;
    	
    	if(root.left != null){
    		min = Math.min(minElem(root.left), min);
    	}
    	
    	if(root.right != null){
    		min = Math.min(minElem(root.right), min);
    	}
    	
    	return min;
    }
    
    public int maxElem(TreeNode root){
    	if(root == null){
    		return Integer.MIN_VALUE;
    	}
    	int max = root.val;
    	
    	if(root.left != null){
    		max = Math.max(maxElem(root.left), max);
    	}
    	
    	if(root.right != null){
    		max = Math.max(maxElem(root.right), max);
    	}
    	
    	return max;
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