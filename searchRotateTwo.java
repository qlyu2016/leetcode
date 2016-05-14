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
        
		int[][] A = {
			 { 1, 0, 0},
		     {-1, 0, 3}
		};

		int[][] B = {
			 { 7, 0, 0 },
		     { 0, 0, 0 },
		     { 0, 0, 1 }
		};
		
		int[][] C = test.multiply(A, B);
		
		for(int i = 0; i < C.length; i ++){
			for(int j = 0; j < C[0].length; j ++){
				System.out.print(C[i][j] + " ");
			}
			System.out.println();
		}
		
	}
}

public class Solution {
    public boolean search(int[] nums, int target) {
    	for(int i = 0; i < nums.length; i ++){
        	if(nums[i] == target){
        		return true;
        	}
        }
    	return false;
    }
}