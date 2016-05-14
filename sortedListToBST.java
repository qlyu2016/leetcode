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

		ListNode head = new ListNode(-10);
		head.next = new ListNode(-3);
		head.next.next = new ListNode(0);
		head.next.next.next = new ListNode(5);
		head.next.next.next.next = new ListNode(9);
//		head.next.next.next.next.next = new ListNode(5);
		TreeNode result = test.sortedListToBST(head);
		TreeNode root = new TreeNode(0);
		root.left = new TreeNode(6);
		root.left.right = new TreeNode(7);
		root.left.left = new TreeNode(2);
		root.left.left.left = new TreeNode(1);
		root.left.left.right = new TreeNode(4);
		root.left.left.right.left = new TreeNode(3);
		
		inOrder(result);
	}
	
	public static void inOrder(TreeNode root){
		if(root == null)
			return ;
		
		System.out.print(root.val + " ");
		inOrder(root.left);
		inOrder(root.right);
	}
}



/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
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
	public TreeNode sortedListToBST(ListNode head) {
        if(head == null)
        	return null;
        
        List<TreeNode> treenodes = new ArrayList<>();
        while(head != null){
        	treenodes.add(new TreeNode(head.val));
        	head = head.next;
        }
        
        return genBST(0, treenodes.size() - 1, treenodes);
	}
	
	public TreeNode genBST(int start, int end, List<TreeNode> treenodes){
		if(start == end)
			return treenodes.get(start);
		if(start + 1 == end){
			treenodes.get(start).right = treenodes.get(end);
			return treenodes.get(start);
		}
		
		int mid = ((start + end) % 2 == 0) ? (start + end) / 2 : (start + end) / 2 + 1;
		TreeNode left = genBST(start, mid - 1, treenodes);
		TreeNode right = genBST(mid + 1, end, treenodes);
		TreeNode root = treenodes.get(mid);
		root.left = left;
		root.right = right;
		
		return root;
	}
}

class ListNode{
	int val;
	ListNode next;
	ListNode(int x){
		val = x;
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