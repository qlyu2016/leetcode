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
import java.util.Set;
import java.util.Stack;
import java.util.Queue;


class Run{
	public static void main(String args[]){
		Solution test = new Solution();

        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        int val = 1;
        ListNode result = test.removeElements(head, val);
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
    public ListNode removeElements(ListNode head, int val) {
        ListNode result = new ListNode(val - 1);
        result.next = head;
        if(head == null)
        	return null;
        
        ListNode tail = result;
        while(tail != null && tail.next != null){
        	if(tail.next.val == val){
        		tail.next = tail.next.next;
        	}else{
        	    tail = tail.next;
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