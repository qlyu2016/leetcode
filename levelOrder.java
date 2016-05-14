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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        List<TreeNode> present = new ArrayList<>();
        if(root != null)
            present.add(root);
        else 
            return result;
        
        while(present.size() > 0){
        	List<Integer> temp = new ArrayList<>();
        	
        	for(int i = 0; i < present.size(); i ++){
        		temp.add(present.get(i).val);
        	}
        	result.add(temp);
        	
        	present = search(present);
        }
        
        return result;
    }
    
    public List<TreeNode> search(List<TreeNode> input){
    	List<TreeNode> result = new ArrayList<>();
    	
    	for(int i = 0; i < input.size(); i ++){
    		if(input.get(i).left != null){
    			result.add(input.get(i).left);
    		}
    		if(input.get(i).right != null){
    			result.add(input.get(i).right);
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