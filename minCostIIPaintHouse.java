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
 
		int[][] costs = new int[][]{{15,17,15,20,7,16,6,10,4,20,7,3,4},{11,3,9,13,7,12,6,7,5,1,7,18,9}};
        		
		System.out.println(test.minCostII(costs));
	}
}

public class Solution {
    public int minCostII(int[][] costs) {
    	if(costs.length == 0){
    		return 0;
    	}
    	if(costs[0].length == 0){
    		return 0;
    	}
    	
    	int k = costs[0].length;
    	int[][] mincost = new int[costs.length][k];
    	mincost[0] = new int[k];
    	for(int i = 0; i < k; i ++){
    		mincost[0][i] = costs[0][i];
    	}
    	
        for(int i = 1; i < costs.length; i ++){
        	mincost[i] = new int[k];
        	for(int j = 0; j < k; j ++){
        		mincost[i][j] = this.minExcept(mincost[i - 1], j) + costs[i][j];
        	}
        }
        
        return Math.min(minExcept(mincost[costs.length - 1], 0),mincost[costs.length - 1][0]);
    }
    
    public int minExcept(int[] costs, int except){
    	int result = Integer.MAX_VALUE;
    	
    	for(int i = 0; i < costs.length; i ++){
    		if(i != except){
    			result = result > costs[i] ? costs[i] : result;
    		}
    	}
    	
    	return result;
    }
}