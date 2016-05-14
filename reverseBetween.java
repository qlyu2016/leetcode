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
import java.util.TreeSet;


class Run{
	public static void main(String args[]){
		Solution test = new Solution();

//        char[][] board = {
//        		  {'A','B','C','E'},
//        		  {'S','F','C','S'},
//        		  {'A','D','E','E'}
//        };
//        String word = "ABCCED";
//		System.out.println(test.exist(board, word));
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		int m = 1;
		int n = 3;
		ListNode result = test.reverseBetween(head, m, n);
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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode result = new ListNode(0);
        result.next = head;
        ListNode start = null;
        if(m == n){
        	return head;
        }
        
        ListNode tail = result;
        int count = 1;
        while(tail != null && count <= n){
        	if(count == m){
        		start = tail;
        		tail = tail.next;
        	}else if(count > m){
        	    ListNode temp = tail.next;
        	    if(tail != null && tail.next != null)
        	        tail.next = tail.next.next;
        	    ListNode temp2 = start.next;
        	    start.next = temp;
        	    if(temp != null)
        	        temp.next = temp2;
        	}else{
        		tail = tail.next;
        	}
        	
        	count ++;
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