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

        int[] preorder = new int[]{1,2,3};
        int[] inorder = new int[]{3,2,1};
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
    	if(preorder == null && inorder == null || preorder.length == 0){
    		return null;
    	}
        return build(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }
    
    public TreeNode build(int[] preorder, int pstart, int pend, int[] inorder, int istart, int iend){
    	if(pend - pstart == 0 || pstart == preorder.length || istart == inorder.length){
        	return null;
        }
        
        TreeNode root = new TreeNode(preorder[pstart]);
        
        int i = 0;
        while(inorder[istart + i] != preorder[pstart]){
        	i ++;
        }
        
        boolean c1 = pstart + i + 1 <= pend;
        boolean c2 = pend <= preorder.length;
        boolean c3 = istart + i + 1 <= iend;
        boolean c4 = iend <= inorder.length;
        if( c1 && c2 && c3 && c4){
        	
        	root.left = build(preorder, pstart + 1, pstart + i + 1, inorder, istart, istart + i);
        	
        	root.right = build(preorder, pstart + i + 1, pend, inorder, istart + i + 1, iend);
        }
        
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
