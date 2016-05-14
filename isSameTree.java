package leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


class Run{
	public static void main(String args[]){
		Solution test = new Solution();

		
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
    public boolean isSameTree(TreeNode p, TreeNode q) {        
        if(p == null && q == null)
        	return true;
        if(p == null && q != null || p != null && q == null)
        	return false;
        
        if(p.val != q.val){
        	return false;
        }
        
        boolean leftTree = isSameTree(p.left, q.left);
        boolean rightTree = isSameTree(p.right, q.right);
        
        if(leftTree && rightTree)
        	return true;
        else
        	return false;
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