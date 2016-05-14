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

       ListNode headA = new ListNode(3);
       ListNode headB = new ListNode(2);
       headB.next = headA;
        
        System.out.print(test.getIntersectionNode(headA, headB).val);
		
	}
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
        	return null;
        }
        
        int lengtha = 1;
        int lengthb = 1;
    	ListNode taila = headA;
    	ListNode tailb = headB;
    	while(taila.next != null){
    		taila = taila.next;
    		lengtha ++;
    	}
    	
    	while(tailb.next != null){
    		tailb = tailb.next;
    		lengthb ++;
    	}
    	
    	if(taila == tailb){
    		taila = headA;
    		tailb = headB;
    		while(true){
    		    if(lengtha < lengthb){
    			    tailb = tailb.next;
    			    lengthb --;
    		    }else if(lengtha > lengthb){
    			    taila = taila.next;
    			    lengtha --;
    		    }else{
    		    	if(taila == tailb){
    		    		break ;
    		    	}
    			    taila = taila.next;
    			    tailb = tailb.next;
    			    lengtha --;
    			    lengthb --;
    		    }
    		}
    		return taila;
    	}else{
    		return null;
    	}
    }
}

class ListNode{
	int val;
	ListNode next;
	ListNode(int x){
		val = x;
	}
}