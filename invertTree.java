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
        TreeNode temp = new TreeNode(2);
        root.left = temp;
        temp = new TreeNode(7);
        root.right = temp;
        temp = new TreeNode(1);
        root.left.left = temp;
        temp = new TreeNode(3);
        root.left.right = temp;
        temp = new TreeNode(6);
        root.right.left = temp;
        temp = new TreeNode(9);
        root.right.right = temp;
        
        TreeNode result = test.invertTree(root);
        inOrder(result);
	}
	
	public static void inOrder(TreeNode root){
		if(root == null)
			return ;
		
		System.out.print(root.val + "->");
		inOrder(root.left);
		inOrder(root.right);
		return ;
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
    public TreeNode invertTree(TreeNode root) {
        TreeNode result = root;
        
        if(root == null)
        	return null;
        
        
        TreeNode left = invertTree(root.right);
        TreeNode right= invertTree(root.left);
        
        result.left = left;
        result.right = right;
        
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