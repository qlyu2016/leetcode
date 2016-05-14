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
		
		ListNode head = new ListNode(1);
		head.next = new ListNode(4);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(2);
		
		ListNode result = test.insertionSortList(head);
		while(result != null){
			System.out.print(result.val + " ");
			result = result.next;
		}
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
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode result = new ListNode(Integer.MIN_VALUE);
        boolean hasCheck = false;
        
        while(head != null){
        	ListNode tail = result;
        	hasCheck = false;
        	while(tail != null && tail.next != null){
        		if(head.val >= tail.val && head.val <= tail.next.val){
        			ListNode next = head.next;
        			head.next = tail.next;
        			tail.next = head;
        			head = next;
        			hasCheck = true;
        			break;
        		}else{
        			tail = tail.next;
        		}
        	}
        	if(!hasCheck){
        	    tail.next = head;
        	    head = head.next;
        	    tail.next.next = null;
        	}
        }
        
        return result.next;
    }
}

class ListNode{
	int val;
	ListNode next;
	ListNode(int x){
		val = x;
	}
}