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
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null){
        	return;
        }
        
        TreeLinkNode curLevel;
        while(root.left != null){
        	curLevel = root;
        	while(curLevel != null){
        		curLevel.left.next = curLevel.right;
        		if(curLevel.next != null){
        			curLevel.right.next = curLevel.next.left;
        		}
        		curLevel = curLevel.next;
        	}
        	root = root.left;
        }
    }
}