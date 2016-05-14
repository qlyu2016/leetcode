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
        
        List<String> result = test.binaryTreePaths(root);
        for(int i = 0; i < result.size(); i ++){
        	System.out.println(result.get(i));
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
	List<String> result = new ArrayList<>();
	
    public List<String> binaryTreePaths(TreeNode root) {
    	
        if(root != null)
        	findPath(root, String.valueOf(root.val));
        
        return result;
    }
    
    public void findPath(TreeNode root, String path){
    	if(root.right == null && root.left == null){
    		result.add(path);
    	}
    	
    	if(root.right != null){
    		findPath(root.right, path.concat("->" + root.right.val));
    	}
    	
    	if(root.left != null){
    		findPath(root.left, path.concat("->" + root.left.val));
    	}
    	
    		
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