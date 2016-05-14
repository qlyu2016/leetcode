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

//		TreeNode root = new TreeNode(1);
//		root.left = new TreeNode(2);
//		root.right = new TreeNode(2);
//		root.right.left = new TreeNode(3);
//		root.left.left = new TreeNode(2);
//		root.left.left.left = new TreeNode(1);
//		root.left.left.right = new TreeNode(4);
//		root.left.left.right.left = new TreeNode(3);
		
		int n = 277;
		
		System.out.println(test.numSquares(n));
		
	}
}

public class Solution {
	
    public int numSquares(int n) {
        int[] dps = new int[n + 1];
    	Arrays.fill(dps, Integer.MIN_VALUE - 2);
    	for(int i = 1; i * i <= n; i ++){
    		dps[i * i] = 1;
    	}
        
    	for(int i = 1; i <= n; i ++){
    		for(int j = 1; i + j * j <= n; j ++){
    			dps[i + j * j] = Math.min(dps[i] + 1, dps[i + j * j]);
    		}
    	}
    	
    	return dps[n];
    }
}