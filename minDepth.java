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
        TreeNode temp = new TreeNode(2);
        root.left = temp;
        temp = new TreeNode(3);
        root.right = temp;
        temp = new TreeNode(4);
        root.right.right = temp;
        temp = new TreeNode(5);
        root.left.right = temp;
        
        System.out.println(test.minDepth(root));
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
	
	public int minDepth(TreeNode root) {
		if(root == null)
			return 0;
        if(root.right == null && root.left == null)
        	return 1;
        
        if(root.right == null)
        	return minDepth(root.left) + 1;
        else if(root.left == null)
        	return minDepth(root.right) + 1;
        else
        	return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
     
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