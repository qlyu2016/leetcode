package leetcode;


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
         ListNode result = null;
         ListNode temp;
         ListNode in1,in2;
         in1 = l1; in2 = l2;
         int forward = 0;
         
         result = new ListNode((in1.val + in2.val) % 10);
         if((in1.val + in2.val) / 10 != 0)
        	 forward = 1;
         else
        	 forward = 0;
         temp = result;
         in1 = in1.next;
         in2 = in2.next;
         while(in1 != null || in2 != null){
        	 if(in1 != null && in2 != null){
        		 if(forward == 0){
        		     temp.next = new ListNode((in1.val + in2.val) % 10);
        		     temp = temp.next;
        		 }
        		 else {
        			 temp.next = new ListNode((in1.val + in2.val + 1) % 10);
        			 temp = temp.next;
        		 }
        		 
        		 if((in1.val + in2.val + forward) / 10 != 0)
                	 forward = 1;
                 else
                	 forward = 0;
                 in1 = in1.next;
                 in2 = in2.next;
        	 }else if(in1 != null && in2 == null){
        		 if(forward == 0){
        		     temp.next = new ListNode((in1.val) % 10);
        		     temp = temp.next;
        		 }
        		 else {
        			 temp.next = new ListNode((in1.val + 1) % 10);
        			 temp = temp.next;
        		 }
        		 
        		 if((in1.val + forward) / 10 != 0)
                	 forward = 1;
                 else
                	 forward = 0;
                 in1 = in1.next;
        	 }else if(in1 == null && in2 != null){
        		 if(forward == 0){
        		     temp.next = new ListNode((in2.val) % 10);
        		     temp = temp.next;
        		 }
        		 else {
        			 temp.next = new ListNode((in2.val + 1) % 10);
        			 temp = temp.next;
        		 }
        		 
        		 if((in2.val + forward) / 10 != 0)
                	 forward = 1;
                 else
                	 forward = 0;
                 in2 = in2.next;
        	 }
        		 
         }
         
         if(forward == 1){
        	 temp.next = new ListNode(1);
        	 temp = temp.next;
         }
       
    	return result;
    }
    
    public static void main(String args[]){
    	ListNode l1 , l2, result;
    	l1 = new ListNode(1);
    	l1.next = new ListNode(8);
    	l1.next.next = new ListNode(3);
    	l2 = new ListNode(7);
    	l2.next = new ListNode(1);
    	result = addTwoNumbers(l1,l2);
    	while(result != null){
    		System.out.print(result.val);
    		result = result.next;
    	}
    }
}

class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
}