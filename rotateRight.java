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

		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		int k = 2;
		
		ListNode result = test.rotateRight(head, k);
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
    public ListNode rotateRight(ListNode head, int k) {
        ListNode result = new ListNode(0);
        if(head == null || head.next == null)
        	return head;
        
        int length = 0;
        ListNode tail = head;
        while(tail != null){
        	tail = tail.next;
        	length ++;
        }
        
        if(k >= length){
        	k = k % length;
        }
        tail = head;
        for(int i = 0; i < length - k - 1; i ++){
        	tail = tail.next;
        }
        
        result.next = tail.next;
        tail.next = null;
        tail = result;
        while(tail.next != null){
        	tail = tail.next;
        }
        tail.next = head;
        
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