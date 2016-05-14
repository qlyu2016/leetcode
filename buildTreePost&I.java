package leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
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

        int[] preorder = new int[]{-1};
        int[] inorder = new int[]{-1};
        TreeNode result = test.buildTree(preorder, inorder);
        
        
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder == null && inorder == null || postorder.length == 0){
        	return null;
        }
        
        return build(inorder, 0, inorder.length, postorder, 0, postorder.length);
    }
    
    public TreeNode build(int[] inorder, int istart, int iend, int[] postorder, int pstart, int pend){
    	if(iend - istart == 0 || pstart == postorder.length || istart == inorder.length){
    		return null;
    	}
    	
    	TreeNode root = new TreeNode(postorder[pend - 1]);
    	
    	int i = 0;
    	while(inorder[iend - i - 1] != postorder[pend - 1]){
    		i ++;
    	}
    	
    	boolean c1 = pstart + i + 1 <= pend;
        boolean c2 = pend <= postorder.length;
        boolean c3 = istart + i + 1 <= iend;
        boolean c4 = iend <= inorder.length;
        if( c1 && c2 && c3 && c4){
        	
        	root.left = build(inorder, istart, iend - i - 1, postorder, pstart, pend - i - 1);
        	
        	root.right = build(inorder, iend - i, iend, postorder, pend - i - 1, pend - 1);
        }
        
        return root;
    }
}