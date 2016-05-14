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
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		
		test.reorderList(head);
		while(head != null){
			System.out.print(head.val + " ");
			head = head.next;
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
    public void reorderList(ListNode head) {
        List<ListNode> record = new ArrayList<>();
        if(head == null || head.next == null)
        	return ;
        
        ListNode tail = head;
        while(tail != null){
        	record.add(tail);
        	tail = tail.next;
        	record.get(record.size() - 1).next = null;
        }
        
        int left = 0;
        int right = record.size() - 1;
        for(; left < right; left ++, right --){
        	if(right < record.size() - 1){
        		record.get(right + 1).next = record.get(left);
        	}
        	record.get(left).next = record.get(right);
        }
        
        if(left == right){
        	record.get(right + 1).next = record.get(right);
        }
    }
}

class ListNode{
	int val;
	ListNode next;
	ListNode(int x){
		val = x;
	}
}