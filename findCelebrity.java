package leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
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

        int[] nums = new int[]{1,2,0,1};
        System.out.println(test.longestConsecutive(nums));
        
        
	}
}

/* The knows API is defined in the parent class Relation.
boolean knows(int a, int b); */

public class Solution extends Relation {
     public int findCelebrity(int n) {
         int[] beknow = new int[n];
    	 
    	 for(int i = 0; i < n; i ++){
    		 for(int j = 0; j < n; j ++){
    			 if(i == j){
    				 continue;
    			 }
    			 
    			 if(beknow[j] >= 0){
    				 if(knows(i, j)){
    					 beknow[i] = -1;
    					 beknow[j]++;
    				 }else{
    					 beknow[j] = -1;
    				 }
    			 }
    		 }
    	 }
    	 
    	 for(int i = 0; i < n; i ++){
    		 if(beknow[i] == n - 1){
    			 for(int j = 0; j < n; j ++){
    				 if(i == j){
    					 continue;
    				 }
    				 if(knows(i,j)){
    					 return -1;
    				 }
    			 }
    			 return i;
    		 }
    	 }
    	 
    	 return -1;
     }
     
}