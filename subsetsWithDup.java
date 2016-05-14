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

//		TreeNode root = new TreeNode(1);
//		root.left = new TreeNode(2);
//		root.right = new TreeNode(2);
//		root.right.left = new TreeNode(3);
//		root.left.left = new TreeNode(2);
//		root.left.left.left = new TreeNode(1);
//		root.left.left.right = new TreeNode(4);
//		root.left.left.right.left = new TreeNode(3);
		
		int[] nums = {0};
		
		List<List<Integer>> result = test.subsetsWithDup(nums);
		
		for(int i = 0; i < result.size(); i ++){
			List<Integer> temp = result.get(i);
			for(int j = 0; j < temp.size(); j ++){
				System.out.print(temp.get(j) + " ");
			}
			System.out.println();
		}
	}
	
	public static void inOrder(TreeNode root){
		if(root == null)
			return ;
		
		System.out.print(root.val + " ");
		inOrder(root.left);
		inOrder(root.right);
	}
}

public class Solution {
	List<List<Integer>> result = new ArrayList<>();
	
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if(nums.length == 0)
        	return result;
        
        Arrays.sort(nums);
        subset(0, nums, new ArrayList<>());
        
        return result;
    }
    
    public void subset(int start, int[] nums, List<Integer> list){
    	if(start == nums.length - 1){
    		if(start - 1 >= 0 && nums[start] == nums[start - 1]){
    			int i = 1;
    	        while((start - i) >= 0 && (list.size() - i) >= 0 && nums[start - i] == list.get(list.size() - i)){
    			   i ++;
    			}
    	        if((start - i) >= 0 && nums[start - i] == nums[start]){
    	             result.add(list);
    	        }else{
    	        	List<Integer> copy = new ArrayList<>(list);
        		    copy.add(nums[start]);
        		    result.add(copy);
        		    result.add(list);
    	        }
    		}else{
    		    List<Integer> copy = new ArrayList<>(list);
    		    copy.add(nums[start]);
    		    result.add(copy);
    		    result.add(list);
    		}
    	    
    	    return ;
    	}
    	
    	if(start >= 1 && nums[start] == nums[start - 1]){
			int i = 1;
	        while((start - i) >= 0 && (list.size() - i) >= 0 && nums[start - i] == list.get(list.size() - i)){
			   i ++;
			}
	        if((start - i) >= 0 && nums[start - i] == nums[start]){
	        	subset(start + 1, nums, list);
	        }else{
	        	subset(start + 1, nums, list);
	        	List<Integer> copy = new ArrayList<>(list);
	        	copy.add(nums[start]);
	        	subset(start + 1, nums, copy);
	        }
		}else{
			subset(start + 1, nums, list);
	    	List<Integer> copy = new ArrayList<>(list);
	    	copy.add(nums[start]);
	    	subset(start + 1, nums, copy);
		}
    }
}