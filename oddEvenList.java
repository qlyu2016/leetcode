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
		
		ListNode result = test.oddEvenList(head);
		while(result != null){
			System.out.print(result.val + " ");
			result = result.next;
		}
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
    public ListNode oddEvenList(ListNode head) {
        List<ListNode> odd = new ArrayList<>();
        List<ListNode> even = new ArrayList<>();
        ListNode result = new ListNode(0);
        if(head == null){
        	return null;
        }
        
        ListNode tail = head;
        int count = 1;
        while(tail != null){
        	if(count % 2 == 0){
        		even.add(tail);
        		tail = tail.next;
        		even.get(even.size() - 1).next = null;
        	}else{
        		odd.add(tail);
        		tail = tail.next;
        		odd.get(odd.size() - 1).next = null;
        	}
        	count ++;
        }
        
        if(odd.size() != 0){
        	result.next = odd.get(0);
        }
        
        for(int i = 0; i < odd.size() - 1; i ++){
        	odd.get(i).next = odd.get(i + 1);
        }
        
        if(odd.size() > 0 && even.size() != 0){
        	odd.get(odd.size() - 1).next = even.get(0);
        }
        if(odd.size() == 0){
        	result.next = even.get(0);
        }
        
        for(int i = 0; i < even.size() - 1; i ++){
        	even.get(i).next = even.get(i + 1);
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