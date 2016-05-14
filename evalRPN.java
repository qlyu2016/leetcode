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
		
		String[] tokens = {
			"2", "1", "+", "3", "*"
		};
		
		System.out.println(test.evalRPN(tokens));
	}
	
	public static void inOrder(TreeNode root){
		if(root == null)
			return ;
		
		System.out.print(root.val + " ");
		inOrder(root.left);
		inOrder(root.right);
	}
}

public class Solution {
	private static HashMap<String, Integer> map = new HashMap<>();
	static{
		map.put("+", 0);
		map.put("-", 1);
		map.put("*", 2);
		map.put("/", 3);
		
	}
    public int evalRPN(String[] tokens) {
        Stack<Integer> record = new Stack();
        int result = 0;
        
        if(tokens.length == 0)
        	return result;
        
        for(int i = 0; i < tokens.length; i ++){
        	if(tokens[i].length() > 1 || ((tokens[i].charAt(0) - '0') <= 9 && (tokens[i].charAt(0) - '0') >= 0)){
        		int temp = Integer.parseInt(tokens[i]);
        		record.push(temp);
        	}else{
        		int back = record.pop();
        		int front = record.pop();
        		int operator = this.map.get(tokens[i]);
        		record.push(calculate(front, back, operator));
        	}
        }
        
        return record.pop();
    }
    
    public int calculate(int front, int back, int operator){
    	if(operator == 0){
    		return front + back;
    	}else if(operator == 1){
    		return front - back;
    	}else if(operator == 2){
    		return front * back;
    	}else if(operator == 3){
    		return front / back;
    	}else{
    		System.out.println("Error");
    		return Integer.MIN_VALUE;
    	}
    }
}