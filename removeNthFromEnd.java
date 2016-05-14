package leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;




class Run{
	public static void main(String args[]){
		Solution test = new Solution();
        
		ListNode head = new ListNode(1);
		
		int n = 1;
		
        ListNode result = test.removeNthFromEnd(head, n);
        
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode[] temp = new ListNode[n + 1];
        ListNode done = head;
        
        while(done != null){
        	for(int i = 0; i <= n; i ++){
        		if(i == n)
        		    temp[i] = done;
        		else
        			temp[i] = temp[i + 1];
        	}
        	done = done.next;
        }
        if(temp.length >= 3){
        	if(temp[0] != null)
                temp[0].next = temp[2];
        	else
        		head = head.next;
        }else{
        	if(temp[0] != null)
        	    temp[0].next = null;
        	else
        		head = head.next;
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