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

public class Solution {
    public boolean isPalindrome(String s) {
        List<String> alpha = new ArrayList<>();
        
        for(int i = 0; i < s.length(); i ++){
        	char item = s.charAt(i);
        	if(item >= 'A' && item <= 'Z'){
        		item = (char) (item - 'A' + 'a');
        	}
        	if(item >= 'a' && item <= 'z' || item >= '0' && item <= '9'){
        		alpha.add(String.valueOf(item));
        	}
        }
        
        int left = 0;
        int right = alpha.size() - 1;
        for(; left < right; left ++, right --){
        	if(!alpha.get(left).equals(alpha.get(right))){
        		return false;
        	}
        }
        
        return true;
    }
}
