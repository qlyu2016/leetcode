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
        ListNode temp = new ListNode(1);
        head.next = temp;
        temp = new ListNode(1);
        head.next.next = temp;
//        temp = new ListNode(2);
//        head.next.next.next = temp;
//        temp = new ListNode(3);
//        head.next.next.next.next = temp;
        
        
        ListNode result = test.deleteDuplicates(head);
        
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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null)
        	return head;
    	
    	ListNode present = head;
    	
    	while(present != null && present.next != null){
    		if(present.val == present.next.val){
    			present.next = present.next.next;
    		}else{
    		    present = present.next;
    		}
    	}
    	
        
    	return head;
    }
}

class ListNode{
	int val;
	ListNode next;
	ListNode(int x){
		val = x;
	}
}