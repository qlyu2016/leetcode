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

        TreeNode root = new TreeNode(1);
        List<Integer> result = test.rightSideView(root);
        
        for(int i = 0; i < result.size(); i ++){
        	System.out.print(result.get(i) + " ");
        }
        
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
    public List<Integer> rightSideView(TreeNode root) {
    	List<TreeNode> pre = new ArrayList<>();
    	List<TreeNode> now = new ArrayList<>();
    	List<Integer> result = new ArrayList<>();
    	if(root == null){
    		return result;
    	}
    	
    	now.add(root);
    	while(now.size() > 0){
    		pre = new ArrayList<>(now);
    		now.clear();
    		for(int i = 0; i < pre.size(); i ++){
    			if(pre.get(i).left != null){
    				now.add(pre.get(i).left);
    			}
    			if(pre.get(i).right != null){
    				now.add(pre.get(i).right);
    			}
    		}
    		result.add(pre.get(pre.size() - 1).val);
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