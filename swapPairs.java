package leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;


class Run{
	public static void main(String args[]){
		Solution test = new Solution();

        ListNode head = new ListNode(1);
        ListNode tail = head;
        ListNode temp = new ListNode(2);
        tail.next = temp;
        tail = tail.next;
        temp = new ListNode(3);
        tail.next = temp;
        tail = tail.next;
        temp = new ListNode(4);
        tail.next = temp;
        tail = tail.next;
        
        ListNode result = test.swapPairs(head);
        
        while(result != null){
             System.out.print(result.val + "->");
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
    public ListNode swapPairs(ListNode head) {
        if(head == null)
        	return head;
    	if(head.next == null)
        	return head;
        
    	ListNode first = head;
    	ListNode second = head.next;
    	head = second;
    	ListNode temp = first;
    	while(first != null && second != null){
    		temp.next = second;
    		first.next = second.next;
    		second.next = first;
    		temp = first;
    		first = first.next;
    		if(first != null)
    			second = first.next;
    	}
    	
    	return head;
    }
}

class ListNode{
	int val;
	ListNode next;
	ListNode(int x){val = x;}
}