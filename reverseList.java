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

        TreeNode root = new TreeNode(5);
        root.left  = new TreeNode(14);
//        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
//        root.right.right = new TreeNode(20);
        
        System.out.print(test.isValidBST(root));
		
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
    public ListNode reverseList(ListNode head) {
        List<ListNode> record = new ArrayList<>();
        if(head == null)
        	return head;
        
        while(head != null){
        	record.add(head);
        	head = head.next;
        	record.get(record.size() - 1).next = null;
        }
        
        for(int i = record.size() - 1; i > 0; i --){
        	record.get(i).next = record.get(i - 1);
        }
        
        return record.get(record.size() - 1);
    }
}

class ListNode{
	int val;
	ListNode next;
	ListNode(int x){
		val = x;
	}
}