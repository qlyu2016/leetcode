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
    public int countNodes(TreeNode root) {  
        if(root==null) return 0;  
          
        int l = getLeft(root) + 1;  
        int r = getRight(root) + 1;  
          
        if(l==r) {  
            return (2<<(l-1)) - 1;  
        } else {  
            return countNodes(root.left) + countNodes(root.right) + 1;  
        }  
    }  
      
    private int getLeft(TreeNode root) {  
        int count = 0;  
        while(root.left!=null) {  
            root = root.left;  
            ++count;  
        }  
        return count;  
    }  
      
    private int getRight(TreeNode root) {  
        int count = 0;  
        while(root.right!=null) {  
            root = root.right;  
            ++count;  
        }  
        return count;  
    }  
}