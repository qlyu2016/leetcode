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
        System.out.println(test.hasCycle(head));
	}
}

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
	
    public boolean hasCycle(ListNode head) {
    	if(head == null)
    		return false;
    	if(head.next == null)
    		return false;
    	
        ListNode fast = head.next;
        ListNode slow = head;
    	while(fast != null && slow != null){
    		if(fast == slow)
    		    return true;
    		
    		if(fast.next == null)
    			return false;
    		else{
    		    fast = fast.next.next;
    		    slow = slow.next;
    		}
    	}
    	
    	return false;
    }
}

class ListNode{
	int val;
	ListNode next;
	ListNode(int x){
		val = x;
		next = null;
	}
}