package leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;




class Run{
	public static void main(String args[]){
		Solution test = new Solution();

		ListNode l1 = null;
		ListNode l2 = new ListNode(0);
        System.out.println(test.mergeTwoLists(l1, l2));
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode done = head;
        
        if(l1 == null && l2 == null){
        	return null;
        }
        
        if(l1 == null && l2 != null){
        	
        	while(l2 != null){
            	ListNode temp = new ListNode(l2.val);
        		done.next = temp;
        		done = done.next;
        		l2 = l2.next;
            }
        }
        
        if(l2 == null && l1 != null){
        	
        	while(l1 != null){
            	ListNode temp = new ListNode(l1.val);
        		done.next = temp;
        		done = done.next;
        		l1 = l1.next;
            }
        }
        
        if(l1 != null && l2 != null){
        	
            while(l1 != null && l2 != null){
        	    if(l1.val < l2.val){
        		   ListNode temp = new ListNode(l1.val);
        		   done.next = temp;
        		   done = done.next;
        		   l1 = l1.next;
        	    }else{
        		   ListNode temp = new ListNode(l2.val);
        		   done.next = temp;
        		   done = done.next;
        		   l2 = l2.next;
        	    }
            }
        
            while(l1 != null){
        	    ListNode temp = new ListNode(l1.val);
    		    done.next = temp;
    		    done = done.next;
    		    l1 = l1.next;
            }
        
            while(l2 != null){
        	    ListNode temp = new ListNode(l2.val);
    		    done.next = temp;
    		    done = done.next;
    		    l2 = l2.next;
            }
        }
        
        return head.next;
    }
}


class ListNode {
	  int val;
	  ListNode next;
	  
	  ListNode(int x){ 
		  this.val = x; 
      }
}