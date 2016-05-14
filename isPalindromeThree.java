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
        head.next = new ListNode(0);
        head.next.next = new ListNode(1);
        System.out.println(test.isPalindrome(head));
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
    public boolean isPalindrome(ListNode head) {
        Stack<ListNode> record = new Stack<>();
        if(head == null || head.next == null)
        	return true;
        
        ListNode tail = head;
        int length = 0;
        while(tail != null){
        	length ++;
        	tail = tail.next;
        }
        
        tail = head;
        int count = 0;
        while(tail != null){
        	if(count < length / 2){
        		record.push(tail);
        	}else if(length % 2 == 1 && count == length / 2){
        		;
        	}else{
        		if(tail.val == record.peek().val){
        			record.pop();
        		}else{
        			return false;
        		}
        	}
        	
        	tail = tail.next;
        	count ++;
        }
        
        return true;
    }
}

class ListNode{
	int val;
	ListNode next;
	ListNode(int x){
		val = x;
	}
}