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
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null)
        	return null;
        if(nums.length == 0)
        	return null;
    	
    	return toBST(nums, 0, nums.length - 1);
    }
    
    public TreeNode toBST(int[] nums, int start, int end){
    	if(start == end)
    		return new TreeNode(nums[start]);
    	if(end - start == 1){
    		TreeNode root = new TreeNode(nums[start]);
    		root.right = new TreeNode(nums[end]);
    		return root;
    	}
    		
    	int mid = (start + end) / 2;
    	TreeNode root = new TreeNode(nums[mid]);
    	
    	TreeNode left = toBST(nums, start, mid - 1);
    	TreeNode right = toBST(nums, mid + 1, end);
    	root.left = left;
    	root.right = right;
    	
    	return root;
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