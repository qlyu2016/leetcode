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
        
		
	}
}

public class Solution {
    public int findDuplicate(int[] nums) {
        for(int i = 0; i < nums.length - 1; i ++){
        	for(int j = i + 1; j < nums.length; j ++){
        		if(nums[i] == nums[j]){
        			return nums[i];
        		}
        	}
        }
        
        return -1;
    }
}