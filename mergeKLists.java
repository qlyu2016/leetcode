package leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;




class Run{
	public static void main(String args[]){
		Solution test = new Solution();
        
		ListNode[] lists = new ListNode[6];
		lists[0] = new ListNode(-10);
		lists[1] = new ListNode(-5);
		lists[2] = new ListNode(4);
		lists[3] = new ListNode(-8);
		lists[4] = new ListNode(-9);
		lists[5] = new ListNode(-3);
		
        System.out.println(test.mergeKLists(lists));

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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode(0);
        ListNode done = head;
        
        if(lists.length == 0)
        	return null;
        if(lists.length == 1)
        	return lists[0];
        
        MinHeap minHeap = new MinHeap();
        minHeap.buildMinHeap(lists);
        
        while(minHeap.getSize() > 0){
            ListNode min = minHeap.deleteMin();
            done.next = min;
            done = done.next;
        
            if(min.next != null){
            	minHeap.add(min.next);
            }
        }
        
        return head.next;
    }
}

class MinHeap{
    private ListNode[] heap;
    private int size = 0;
    
    //maintain the min heap
    public void minHeapify(int i){
    	int left = leftChild(i);
    	int right = rightChild(i);
    	int least = -1;
    	if(left < size && heap[left].val < heap[i].val){
    		least = left;
    	}else{
    		least = i;
    	}
    	
    	if(right < size && heap[right].val < heap[least].val){
    		least = right;
    	}
    	
    	if(least != i){
    		ListNode temp = heap[least];
    		heap[least] = heap[i];
    		heap[i] = temp;
    		minHeapify(least);
    	}
    }
    
    public void buildMinHeap(ListNode[] lists){
    	this.heap = new ListNode[lists.length];
    	
    	for(int i = 0; i < lists.length; i ++){
    	    if(lists[i] != null){
    	    	this.heap[size] = lists[i];
    	        size ++;
    	    }
    	}

    	for(int i = (size - 1) / 2; i >= 0; i --){
    		minHeapify(i);
    	}
    }
    
    public ListNode deleteMin(){
    	ListNode temp = this.heap[0];
    	this.heap[0] = this.heap[size - 1];
    	this.heap[size - 1] = temp;
    	this.size --;
    	minHeapify(0);
    	return temp;
    }
    
    public void add(ListNode target){
    	this.size ++;
        this.heap[size - 1] = target;
        int present = size - 1;
        
        while(present > 0){
        	if(target.val > this.heap[parent(present)].val){
        		break;
        	}else{
        		this.heap[present] = this.heap[parent(present)];
        		present = parent(present);
        	}
        }
        
        this.heap[present] = target;
    }
    
    public int parent(int i){
    	return (i - 1) / 2;
    }
    
    public int leftChild(int i){
    	return 2 * i + 1;
    }
    
    public int rightChild(int i){
    	return 2 * i + 2;
    }
    
    public int getSize(){
    	return this.size;
    }
    
}

class ListNode{
	int val;
	ListNode next;
	ListNode(int x){
		val = x;
	}
}