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
    public boolean isSymmetric(TreeNode root) {
    	if(root == null)
    		return true;
    	
        return checkSymmetric(root.left, root.right);
    }
    
    public boolean checkSymmetric(TreeNode left, TreeNode right){
    	if(left == null && right == null)
    		return true;
    	if(left == null && right != null || left != null && right == null)
    		return false;
    	
    	if(left.val != right.val)
    		return false;
    	
    	boolean out = checkSymmetric(left.left, right.right);
    	boolean in = checkSymmetric(left.right, right.left);
    	
    	if(out && in)
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