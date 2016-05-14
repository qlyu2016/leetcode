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
        
		int[] ratings = {1,2,4,4,3};
		
		System.out.println(test.candy(ratings));
		
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    	List<List<Integer>> result = new ArrayList<>();        
        List<TreeNode> tlayer = new ArrayList<>();
        List<TreeNode> prelayer = new ArrayList<>();
        int direction = 0;
        if(root == null){
        	return result;
        }
        
        tlayer.add(root);
        while(tlayer.size() > 0){
        	List<Integer> temp = new ArrayList<>();
        	if(direction == 0){
        	    for(int i = 0; i < tlayer.size(); i ++){
        		     temp.add(tlayer.get(i).val);
        	    }
        	    direction = 1;
        	}else{
        		for(int i = tlayer.size() - 1; i >= 0; i --){
       		     temp.add(tlayer.get(i).val);
       	        }
        		direction = 0;
        	}
        	result.add(temp);
        	
        	prelayer.clear();
        	prelayer.addAll(tlayer);
        	tlayer.clear();
        	
        	for(int i = 0; i < prelayer.size(); i ++){
        		if(prelayer.get(i).left != null)
        		    tlayer.add(prelayer.get(i).left);
        		if(prelayer.get(i).right != null)
        		    tlayer.add(prelayer.get(i).right);
        	}
        }
        
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