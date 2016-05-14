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

        TreeNode root = new TreeNode(30);
        root.left = new TreeNode(25);
        root.left.left = new TreeNode(11);
        root.right = new TreeNode(55);
        root.right.left = new TreeNode(42);
        root.right.right = new TreeNode(65);
        int k = 5;
        
        System.out.println(test.kthSmallest(root, k));
		
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
	private int number = Integer.MIN_VALUE;
	private int count = 0;
    public int kthSmallest(TreeNode root, int k) {
    	inOrder(root, k);
    	
    	return number;
    }
    
    public void inOrder(TreeNode root, int k){
    	if(root == null){
    		return ;
    	}
    	
    	inOrder(root.left, k);
    	if(count < k){
    		count ++;
    		if(count == k){
    			this.number = root.val;
    		}
    	}
    	inOrder(root.right, k);
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