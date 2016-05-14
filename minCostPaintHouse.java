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
 
		int[][] costs = new int[][]{{18,17,7},{20,19,4},{5,8,15},{6,3,17}
				,{7,6,6},{8,1,9},{1,11,19},{20,13,18},{15,17,3},{16,20,15}
						,{16,7,15},{15,3,12},{19,5,10},{8,18,15},{2,16,17}
								,{12,17,16},{10,8,16},{6,8,15},{14,3,18}
										,{15,18,2},{20,10,20},{4,18,4},{7,8,2}
												,{4,1,8},{8,13,20},{12,20,4}};
        		
		System.out.println(test.minCost(costs));
	}
}

public class Solution {
	private int result = Integer.MAX_VALUE;
	
    public int minCost(int[][] costs) {
    	if(costs.length == 0){
    		return 0;
    	}
    	int[][] mincost = new int[costs.length][3];
    	mincost[0] = new int[3];
    	mincost[0][0] = costs[0][0];
    	mincost[0][1] = costs[0][1];
    	mincost[0][2] = costs[0][2];
    	
        for(int i = 1; i < costs.length; i ++){
        	mincost[i] = new int[3];
        	mincost[i][0] = Math.min(mincost[i - 1][1], mincost[i - 1][2]) + costs[i][0]; 
        	mincost[i][1] = Math.min(mincost[i - 1][0], mincost[i - 1][2]) + costs[i][1]; 
        	mincost[i][2] = Math.min(mincost[i - 1][1], mincost[i - 1][0]) + costs[i][2]; 
        }
        
        return Math.min(Math.min(mincost[costs.length - 1][0], mincost[costs.length - 1][1]), mincost[costs.length - 1][2]);
    }
}