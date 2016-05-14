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
    public ListNode detectCycle(ListNode head) {
        if(head == null)
        	return head;
    	
    	ListNode front = head;
        ListNode back = head;
        while(front != null && front.next != null && back != null && back.next != null && back.next.next != null){
        	front = front.next;
        	back = back.next.next;
        	if(front == back){
        		front = head;
        		while(front != back){
        			front = front.next;
        			back = back.next;
        		}
        		return front;
        	}
        }
        
        return null;
        
    }
}

class ListNode{
	int val;
	ListNode next;
	ListNode(int x){
		val = x;
	}
}